package dao;

import entity.CategoryEntity;

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

}
