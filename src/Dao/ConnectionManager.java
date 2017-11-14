package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionManager {

	/**
	 * Get a connection to database
	 * 
	 * @return Connection object
	 */
	public static Connection getConnection() {
		try {
			InitialContext context = new InitialContext();
			DataSource dataSource = (DataSource) context
					.lookup("java:/comp/env/jdbc/sampledb");

			return dataSource.getConnection();
		} catch (SQLException ex) {
			throw new RuntimeException("Error connecting to the database", ex);
		} catch (NamingException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void close(final PreparedStatement statement,
			final ResultSet resultSet) {

		close(statement);
		close(resultSet);

	}

	public static void close(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (final SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void close(PreparedStatement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (final SQLException e) {
				e.printStackTrace();
			}
		}

	}
}