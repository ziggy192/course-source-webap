package dao;

import java.util.List;

public interface IGenericDAO<T,PK>{
	T findByID(PK key);

	void persist(T t);

	T merge(T t);

	void delete(T t);

	List<T> getAll(String queryName);





}
