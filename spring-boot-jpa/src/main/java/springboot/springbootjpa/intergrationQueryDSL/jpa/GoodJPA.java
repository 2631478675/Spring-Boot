package springboot.springbootjpa.intergrationQueryDSL.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import springboot.springbootjpa.intergrationQueryDSL.entity.GoodsInformation;


//spring data jpa整合queryDsl
public interface GoodJPA extends JpaRepository<GoodsInformation,Long>,QuerydslPredicateExecutor<GoodsInformation>{

}
