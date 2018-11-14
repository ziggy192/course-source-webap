package dao;

import entity.CategoryEntity;
import util.DBUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CategoryDAO extends BaseDao<CategoryEntity, Integer> {
	private static CategoryDAO instance;
	private static Object LOCK = new Object();

	public static CategoryDAO getInstance() {
		synchronized (LOCK) {
			if (instance == null) {
				instance = new CategoryDAO();
			}
		}
		return instance;
	}


	public List<CategoryEntity> getCategoryList() {
		EntityManager entityManager = DBUtils.getEntityManager();
		Query namedQuery = entityManager.createNamedQuery("CategoryEntity.getCategoryList");

		return namedQuery.getResultList();


	}

}
