package Dao;

import java.util.List;

public interface IDao <T, PK>{
	T get(PK key);
	
	int create(T entity);
	
	void update(T entity);
	
	void delete(T entity);	
	
	List<T> getAll();
	
	List<T> select(final String sql, final Object... args);
	
	int update(final String sql, final Object... args);
}
