package Models.Writes;

import java.sql.ResultSet;
import java.sql.SQLException;

import Models.Writes.Writes;
import Models.Writes.Writes.WritesPK;

import Dao.Dao;
import Dao.IMapper;

public class WritesDao extends Dao<Writes, WritesPK> {

	private static IMapper<Writes> WRITES_MAPPER = new IMapper<Writes>(){
		@Override
		public Writes map(ResultSet resultSet) throws SQLException{
			Writes writes = new Writes();
			
			writes.setEmail(resultSet.getString("email"));
			writes.setPaperId(resultSet.getInt("paperid"));
			writes.setAuthorOrder(resultSet.getInt("authororder"));
			
			return writes;			
		}
	};
	
	public WritesDao() {
		super(WRITES_MAPPER, Writes.class);
	}	
}