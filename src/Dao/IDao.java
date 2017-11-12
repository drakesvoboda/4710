package Dao;

import java.util.List;

public interface IDao <T, PK>{
	T get(PK key);
	
	void create(T entity);
	
	void update(T entity);
	
	void delete(PK key);	
	
	List<T> getAll();
	
	List<T> select(final String sql, final Object... args);
	
	int update(final String sql, final Object... args);
}
