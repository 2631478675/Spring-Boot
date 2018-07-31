package deki.com.springboot.specs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Iterables.toArray;

public class CustomerSpecs {

	private final static Logger logger = LoggerFactory.getLogger(CustomerSpecs.class);

	/**
	 *
	 * @param entityManager
	 * @param example ： entity class object
	 * @param <T>
	 * @return
	 */
	public static <T> Specification<T> byAuto(final EntityManager entityManager, final T example) {

		//返回实体类对象的类型：Person
		final Class<T> type = (Class<T>) example.getClass();

		System.out.println("返回实体类对象的类型"+type);

		return new Specification<T>() {
			/**
			 *
			 * @param root ：get the attributes of the query
			 * @param query
			 * @param cb : construct the conditions
			 * @return
			 */

			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				List<Predicate> predicates = new ArrayList<>();
				
				EntityType<T> entity = entityManager.getMetamodel().entity(type);

				System.out.println(entity);

				for (Attribute<T, ?> attr : entity.getDeclaredAttributes()) {//5
					//获取实体类对象某一属性的值
					Object attrValue = getValue(example, attr);

					if (attrValue != null) {
						if (attr.getJavaType() == String.class) {   //如果属性的类型是string类型
							if (!StringUtils.isEmpty(attrValue)) {
								predicates.add(cb.like(root.get(attribute(entity, attr.getName(), String.class)), pattern((String) attrValue))); //9
							}
						}
						else {
							predicates.add(cb.equal(root.get(attribute(entity, attr.getName(), attrValue.getClass())), attrValue)); //10
						}
					}

				}
				return predicates.isEmpty() ? cb.conjunction() : cb.and(toArray(predicates, Predicate.class));//11
			}

			/**
			 *
			 * @param example ：entity class object
			 * @param attr attribute
			 * @param <T>
			 * @return
			 */
			private <T> Object getValue(T example, Attribute<T, ?> attr) {
				return ReflectionUtils.getField((Field) attr.getJavaMember(), example);
			}
			
			/**
			 * 13
			 */
			private <E, T> SingularAttribute<T, E> attribute(EntityType<T> entity, String fieldName, Class<E> fieldClass) {
				return entity.getDeclaredSingularAttribute(fieldName, fieldClass);
			}

		};

	}


	/**
	 *
	 * @param str eg: liu
	 * @return %liu%
	 */
	static private String pattern(String str) {
		return "%" + str + "%";
	}

}
