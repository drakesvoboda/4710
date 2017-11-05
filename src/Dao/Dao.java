package Dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public abstract class Dao <T, PK extends Serializable> implements IDao<T, PK> {
	
	protected Class<T> type;
	protected String table_name;
	protected String primary_key;
	protected IMapper<T> mapper;
	
	public Dao(IMapper<T> mapper){
		this.mapper = mapper;
	}
	

	@Override
	public PK create(final T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T get(final PK key) {
		try(Connection con = ConnectionManager.getConnection())
		{
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void delete(final PK key) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<T> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<T> select(final String sql, final Object... args){
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		try(Connection connect = ConnectionManager.getConnection())
		{		
		    preparedStatement = connect.prepareStatement(sql); 
		    
		    for(int i = 0; i < args.length; ++i){	    	
		    	preparedStatement.setObject(i + 1, args[i]);
		    }
		    
		    resultSet = preparedStatement.executeQuery();
		    
		    final List<T> ret = new ArrayList<T>();
		    
		    while(resultSet.next()){	  
		    	ret.add(mapper.map(resultSet));
		    }
		    
		    return ret;
		    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
		return null;
	}
	
}
