package springboot.springbootjpa.intergrationQueryDSL.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.springbootjpa.intergrationQueryDSL.entity.GoodsInformation;
import springboot.springbootjpa.intergrationQueryDSL.service.GoodsInformationService;

import java.util.List;

@RestController
public class QueryController {

    @Autowired
    GoodsInformationService service;

    //仅仅使用QuerySQL来查询
//    @GetMapping(value = "/listGoodByQueryDsl")
//    public List<GoodsInformation> listByQueryDsl(){
//        return service.listByQueryDsl();
//    }


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
        return service.listBySpringDataAndQueryDsl();

    }

}
