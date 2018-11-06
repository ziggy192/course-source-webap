package dao;

import constant.AppConstants;
import entity.CourseEntity;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import util.DBUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


public class CourseDAO extends BaseDao<CourseEntity, Integer> {

	private static Logger logger = LoggerFactory.logger(CourseDAO.class);

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

		logger.info(String.format("searchQueryOnly,query=", query));

		return DBUtils.getEntityManager().createNamedQuery("CourseEntity.findCourseByNameQuery", CourseEntity.class)
				.setParameter("query", query)
				.getResultList();

	}

	public List<CourseEntity> searchCourse(String query
			, List<Integer> domainIdList
			, List<Integer> categoryIdList
			, String sort
			, int page) {

		logger.info(String.format("query=%s|domainId=%s|categoryId=%s|sort=%s|page=%s", query, domainIdList, categoryIdList, sort, page));

			String jpqlQuery = "SELECT c FROM CourseEntity c where c.name like concat('%',:query,'%')";

			if (!domainIdList.isEmpty()) {

				jpqlQuery += "  and c.domainId in ( ";
				for (int i = 0; i < domainIdList.size(); i++) {
					int domainId = domainIdList.get(i);
					jpqlQuery += domainId;
					if (i < domainIdList.size() - 1) {
						jpqlQuery += ",";
					}
				}
				jpqlQuery += ") ";
			}

		if (!categoryIdList.isEmpty()) {

			jpqlQuery += "  and c.categoryId in ( ";
			for (int i = 0; i < categoryIdList.size(); i++) {
				int categoryId = categoryIdList.get(i);
				jpqlQuery += categoryId;
				if (i < categoryIdList.size() - 1) {
					jpqlQuery += ", ";
				}
			}
			jpqlQuery += ") ";
		}


		//sort

		//name-up
		//name-down
		//rating-up
		//rating-down

		//cost-up
		//cost-down

		switch (sort.toLowerCase()) {
			case AppConstants.NAME_UP:
				jpqlQuery += " order by c.name asc ";
				break;
			case AppConstants.NAME_DOWN:
				jpqlQuery += " order by c.name desc";
				break;
			case AppConstants.COST_UP:
				jpqlQuery += " order by c.cost asc ";
				break;
			case AppConstants.COST_DOWN:
				jpqlQuery += " order by c.cost desc";

				break;
			case AppConstants.RATING_UP:
				jpqlQuery += " order by c.rating asc ";
				break;
			case AppConstants.RATING_DOWN:
				jpqlQuery += " order by c.rating desc";

				break;
			default:

				//do nothing
				break;

		}

		//get count result

		int firstResult = AppConstants.PAGE_SIZE * (page - 1);

		logger.info(String.format("jpqlQuery=%s", jpqlQuery));
		EntityManager entityManager = DBUtils.getEntityManager();
		TypedQuery<CourseEntity> typedQuery = entityManager.createQuery(jpqlQuery, CourseEntity.class);
		entityManager.createQuery(jpqlQuery, CourseEntity.class);

		typedQuery = typedQuery.setParameter("query", query);

		typedQuery = typedQuery.setFirstResult(firstResult);
		typedQuery = typedQuery.setMaxResults(AppConstants.PAGE_SIZE);

		return typedQuery.getResultList();
}





}
