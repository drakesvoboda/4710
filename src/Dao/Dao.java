package Dao;


import java.io.Serializable;
import java.lang.annotation.Annotation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import MySqlAnnotations.*;


public abstract class Dao <T, PK> implements IDao<T, PK> {
	
	
	protected IMapper<T> mapper;
	
	protected Class<T> TYPE;
	protected String TABLE_NAME;
	protected String PRIMARY_KEY;
	
	public Dao(IMapper<T> mapper, Class<T> TYPE){
		this.mapper = mapper;
		
		this.TYPE = TYPE;
		
		try
		{
			Annotation annotation = TYPE.getAnnotation(TableName.class);
			TableName tableName = (TableName) annotation;
		
			this.TABLE_NAME = tableName.value();
		} 
		catch(NullPointerException e)
		{
			System.out.println("Class " + TYPE.getName() + " must have the TableName annotation");
		}
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
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try(Connection connect = ConnectionManager.getConnection())
		{		
			preparedStatement = createStatement(connect, sql, args);
		    
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
			ConnectionManager.close(preparedStatement, resultSet);
		}
		return null;
	}
	
	@Override
	public void update(final String sql, final Object... args){
		try(Connection connect = ConnectionManager.getConnection())
		{		
			PreparedStatement preparedStatement = createStatement(connect, sql, args);
		    
		    preparedStatement.executeUpdate();	    
		   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
	}
	
	private PreparedStatement createStatement(final Connection connect, final String sql, final Object... args) throws SQLException{
		PreparedStatement preparedStatement;
		
		preparedStatement = connect.prepareStatement(sql); 
	    
	    for(int i = 0; i < args.length; ++i){	    	
	    	preparedStatement.setObject(i + 1, args[i]);
	    }
		
		return preparedStatement;		
	}
}
