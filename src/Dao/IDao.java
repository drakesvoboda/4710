package Dao;

import java.io.Serializable;
import java.util.List;

public interface IDao <T, PK>{
	PK create(T entity);
	
	T get(PK key);
	
	List<T> getAll();
	
	List<T> select(final String sql, final Object... args);
	
	void update(final String sql, final Object... args);
	
	void delete(PK key);	
}
