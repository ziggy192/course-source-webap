package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtils {

	private static EntityManagerFactory entityManagerFactory;

	private static Object LOCK = new Object();
	public static EntityManager getEntityManager() {
		synchronized (LOCK) {
			if (entityManagerFactory == null) {
				entityManagerFactory = Persistence.createEntityManagerFactory("CourseSourcePersistenceUnit");
			}
		}
		return entityManagerFactory.createEntityManager();
	}

	public static void closeEntityMangerFactory() {
		if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
			entityManagerFactory.close();

		}
	}
}
