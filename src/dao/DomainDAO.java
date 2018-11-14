package dao;

import entity.DomainEntity;
import util.DBUtils;

import java.util.List;

public class DomainDAO extends BaseDao<DomainEntity, Integer> {
	private static DomainDAO instance;

	private static Object LOCK = new Object();
	public static DomainDAO getInstance() {
		synchronized (LOCK) {
			if (instance == null) {
				instance = new DomainDAO();

			}
		}
		return instance;
	}

	public List<DomainEntity> getDomainList() {
		return DBUtils.getEntityManager().createNamedQuery("Domain.getAllDomain").getResultList();
	}




}
