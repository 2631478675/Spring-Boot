package springboot.springbootjpa.intergrationQueryDSL.cotroller;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.springbootjpa.intergrationQueryDSL.entity.GoodsInformation;
import springboot.springbootjpa.intergrationQueryDSL.entity.QGoodsInformation;
import springboot.springbootjpa.intergrationQueryDSL.jpa.GoodJPA;
import springboot.springbootjpa.intergrationQueryDSL.util.Inquirer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class QueryController {

    @Autowired
    private GoodJPA goodJPA;

    @PersistenceContext
    private EntityManager entityManager;

    //仅仅使用QuerySQL来查询
    @GetMapping(value = "/listGoodByQueryDsl")
    public List<GoodsInformation> listByQueryDsl(){

       QGoodsInformation _good = QGoodsInformation.goodsInformation;
       JPAQuery<GoodsInformation> jpaQuery = new JPAQuery<>(entityManager);

        return  jpaQuery.select(_good).from(_good).where(_good.goodsType.TypeID.eq(Long.valueOf("1"))).fetch();
    }


    @GetMapping(value = "/listGoodBySpringDataAndQueryDsl")
    public List<GoodsInformation> listBySpringDataAndQueryDsl(){
//        QGoodsInformation _good = QGoodsInformation.goodsInformation;
//        BooleanExpression expression = _good.goodsType.TypeID.eq(Long.valueOf("1"));
//
//        Iterator<GoodsInformation> iterator = goodJPA.findAll(expression).iterator();
//        List<GoodsInformation> goodsInformations = new ArrayList<>();
//
//        while (iterator.hasNext()){
//            goodsInformations.add(iterator.next());
//        }
//        return goodsInformations;
        //querydsl查询实体
        QGoodsInformation _good = QGoodsInformation.goodsInformation;
        //自定义查询对象
        Inquirer inquirer = new Inquirer();
        //添加查询条件
        inquirer.putExpression(_good.goodsType.TypeID.eq(Long.valueOf("1")));
        //返回查询结果
        return inquirer.iteratorToList(goodJPA.findAll(inquirer.buidleQuery()));
    }

}
