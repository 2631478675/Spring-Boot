package springboot.springbootjpa.intergrationQueryDSL.service;


import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import springboot.springbootjpa.intergrationQueryDSL.entity.GoodsInformation;
import springboot.springbootjpa.intergrationQueryDSL.entity.QGoodsInformation;
import springboot.springbootjpa.intergrationQueryDSL.jpa.GoodJPA;
import springboot.springbootjpa.intergrationQueryDSL.util.Inquirer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/*
http://www.cnblogs.com/morethink/p/7798602.html
 */
@Service
@CacheConfig //声明的类参与缓存
public class GoodsInformationService {
    @Autowired
    private GoodJPA goodJPA;

    //实体管理者
    @PersistenceContext
    private EntityManager entityManager;

//    @Cacheable
//    public List<GoodsInformation> listByQueryDsl(){
//
//        QGoodsInformation _good = QGoodsInformation.goodsInformation;
//
//        JPAQuery<GoodsInformation> jpaQuery = new JPAQuery<>(entityManager);
//
//        return  jpaQuery.select(_good).from(_good).where(_good.goodsType.TypeID.eq(Long.valueOf("1"))).fetch();
//    }
    @Cacheable(cacheNames = "listBySpringDataAndQueryDsl")
    public List<GoodsInformation> listBySpringDataAndQueryDsl(){
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
