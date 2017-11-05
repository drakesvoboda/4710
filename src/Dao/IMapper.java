package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IMapper<T> {
	T map(ResultSet resultSet) throws SQLException;
}
