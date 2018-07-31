package deki.com.springboot.support;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * 自定义RepositoryFactoryBean extends JpaRepositoryFactoryBean
 * @param <T>
 * @param <S>
 * @param <ID>
 */
public class CustomRepositoryFactoryBean<T extends JpaRepository<S, ID>, S, ID extends Serializable> extends JpaRepositoryFactoryBean<T, S, ID> {


	public CustomRepositoryFactoryBean(Class<? extends T> repositoryInterface) {
		super(repositoryInterface);
	}

	/**
	 * 用传入的entityManager，创建实例
	 * @param entityManager
	 * @return
	 */
	@Override
	protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
		return new CustomRepositoryFactory(entityManager);
	}

	/**
	 * 创建RepositoryFactory extends JpaRepositoryFactory
	 */
	private static class CustomRepositoryFactory extends JpaRepositoryFactory {


		public CustomRepositoryFactory(EntityManager entityManager) {
			super(entityManager);
		}

		@Override
		@SuppressWarnings({"unchecked"})
		protected <T, ID extends Serializable> SimpleJpaRepository<?, ?> getTargetRepository(RepositoryInformation information, EntityManager entityManager) {// 4
			return new CustomRepositoryImpl<T, ID>((Class<T>) information.getDomainType(), entityManager);

		}

		@Override
		protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {// 5
			return CustomRepositoryImpl.class;
		}
	}
}