package dao;

import entity.CourseEntity;
import util.DBUtils;

import java.util.List;


public class CourseDAO extends BaseDao<CourseEntity, Integer> {

	private static Object LOCK = new Object();
	private static CourseDAO instance;

	private CourseDAO() {

	}

	public static CourseDAO getInstance() {
		synchronized (LOCK) {
			if (instance == null) {
				instance = new CourseDAO();
			}
		}
		return instance;
	}

	public List<CourseEntity> searchCourse(String query) {
		return DBUtils.getEntityManager().createNamedQuery("CourseEntity.findCourseByNameQuery", CourseEntity.class)
				.setParameter("query", query).getResultList();

	}





}
