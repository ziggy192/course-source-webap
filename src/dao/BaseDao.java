package dao;

import util.DBUtils;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class BaseDao<T,PK> implements IGenericDAO<T,PK> {

	private Class<T> entityClass;

	public BaseDao() {

		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		entityClass = (Class<T>) type.getActualTypeArguments()[0];

	}

	public T findByID(PK key) {
		EntityManager entityManager = DBUtils.getEntityManager();
		return entityManager.find(entityClass, key);

	}

	@Override
	public void persist(T o) {
		EntityManager entityManager = DBUtils.getEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(o);
		entityManager.getTransaction().commit();

	}

	@Override
	public T merge(T o) {
		EntityManager entityManager = DBUtils.getEntityManager();

		entityManager.getTransaction().begin();
		T object = entityManager.merge(o);
		entityManager.getTransaction().commit();
		return object;
	}

	@Override
	public void delete(T o) {
		EntityManager entityManager = DBUtils.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.remove(o);
		entityManager.getTransaction().commit();
	}

	@Override
	public List getAll(String queryName) {
		EntityManager entityManager = DBUtils.getEntityManager();
		return entityManager.createNamedQuery(queryName).getResultList();
	}
}
