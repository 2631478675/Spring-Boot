package deki.com.springboot.support;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import static deki.com.springboot.specs.CustomerSpecs.byAuto;


public class CustomRepositoryImpl <T, ID extends Serializable> extends SimpleJpaRepository<T, ID>  implements CustomRepository<T,ID> {
	
	private final EntityManager entityManager;


	public CustomRepositoryImpl(Class<T> domain, EntityManager entityManager) {
		super(domain, entityManager);
		this.entityManager = entityManager;
	}

	@Override
	public Page<T> findByAuto(T example, Pageable pageable) {
		return findAll(byAuto(entityManager, example),pageable);
	}


}
