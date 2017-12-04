package Dao;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import MySqlAnnotations.*;

public abstract class Dao<T, PK> implements IDao<T, PK> {
	protected IMapper<T> mapper;

	protected Class<T> TYPE;
	protected List<Field> PRIMARY_KEY;
	protected List<Field> COLUMNS;
	protected String TABLE_NAME;

	public Dao(IMapper<T> mapper, Class<T> TYPE) {
		this.mapper = mapper;

		this.TYPE = TYPE;

		try {
			Annotation annotation = TYPE.getAnnotation(TableName.class);
			TableName tableName = (TableName) annotation;

			this.TABLE_NAME = tableName.value();
		} catch (NullPointerException e) {
			try {
				throw new MySqlAnnotationNotFoundException("Class "
						+ TYPE.getName()
						+ " must have the TableName annotation");
			} catch (MySqlAnnotationNotFoundException e1) {
				e1.printStackTrace();
			}
		}

		this.COLUMNS = new ArrayList<Field>();
		this.PRIMARY_KEY = new ArrayList<Field>();

		try {
			for (Field field : TYPE.getDeclaredFields()) {
				if (field.isAnnotationPresent(PrimaryKey.class)) {
					PRIMARY_KEY.add(field);
				}
				if (field.isAnnotationPresent(ColumnName.class)) {
					COLUMNS.add(field);
				}
			}
			if (PRIMARY_KEY == null) {
				throw new MySqlAnnotationNotFoundException(
						"Class "
								+ TYPE.getName()
								+ " must have a field with the PrimaryKey flag annotation");
			}
		} catch (MySqlAnnotationNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void create(final T entity) {
		// TODO Auto-generated method stub
		String columns = ""; // List of column names separated by commas
		String valuesPlaceholder = ""; // List of ? separated by commas
		List<Object> values = new ArrayList<Object>(); // List of objects to
														// fill ?

		try {
			for (Field field : this.COLUMNS) {

				if (field.get(entity) != null) {
					columns = columns.concat(field.getAnnotation(
							ColumnName.class).value()
							+ ",");
					valuesPlaceholder = valuesPlaceholder.concat("?,");
					values.add(field.get(entity));
				}

			}
			columns = columns.substring(0, columns.length() - 1); // Remove last
																	// comma
			valuesPlaceholder = valuesPlaceholder.substring(0,
					valuesPlaceholder.length() - 1); // Remove last comma

		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		update("INSERT INTO " + TABLE_NAME + " (" + columns + ") VALUES ("
				+ valuesPlaceholder + ")",
				values.toArray(new Object[values.size()]));
	}

	@Override
	public T get(final PK key) {
		List<T> matches = select("SELECT * FROM " + TABLE_NAME + " WHERE ");

		if (matches.size() > 0) {
			return matches.get(0);
		}

		return null;
	}

	public void update(final T entity) {
		String SET_STATEMENT = "";
		
		List<Object> values = new ArrayList<Object>(); // List of objects to
														// fill ?

		try {
			for (Field field : this.COLUMNS) {
				if (field.get(entity) != null) {
					SET_STATEMENT = SET_STATEMENT.concat(field.getAnnotation(
							ColumnName.class).value() + " = ?,");
					values.add(field.get(entity));
				}

			}
			SET_STATEMENT = SET_STATEMENT.substring(0,
					SET_STATEMENT.length() - 1); // Remove last comma

		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		update("UPDATE " + TABLE_NAME + " SET " + SET_STATEMENT + " WHERE "
				+ pkSql(entity), values.toArray(new Object[values.size()]));
	}

	@Override
	public void delete(final T entity) {
		update("DELETE FROM " + TABLE_NAME + " WHERE " + pkSql(entity));
	}

	@Override
	public List<T> getAll() {
		return select("SELECT * FROM " + TABLE_NAME);
	}

	@Override
	public List<T> select(final String sql, final Object... args) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try (Connection connect = ConnectionManager.getConnection()) {
			preparedStatement = createStatement(connect, sql, args);

			resultSet = preparedStatement.executeQuery();

			final List<T> ret = new ArrayList<T>();

			while (resultSet.next()) {
				ret.add(mapper.map(resultSet));
			}

			return ret;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionManager.close(preparedStatement, resultSet);
		}
		return null;
	}

	@Override
	public int update(final String sql, final Object... args) {
		PreparedStatement preparedStatement = null;
		int ret = -1;
		try (Connection connect = ConnectionManager.getConnection()) {
			preparedStatement = createStatement(connect, sql, args);

			ret = preparedStatement.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionManager.close(preparedStatement);
		}

		return ret;
	}

	private PreparedStatement createStatement(final Connection connect,
			final String sql, final Object... args) throws SQLException {
		PreparedStatement preparedStatement;

		preparedStatement = connect.prepareStatement(sql);

		for (int i = 0; i < args.length; ++i) {
			preparedStatement.setObject(i + 1, args[i]);
		}

		return preparedStatement;
	}

	private String pkSql(final T entity) {
		String ret = "";
		try {
			for (Field field : PRIMARY_KEY) {
				if (field.get(entity) != null) {
					String column_name = field.getAnnotation(ColumnName.class)
							.value();
					ret = ret.concat(column_name + " = " + field.get(entity)
							+ " AND ");
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		return ret.substring(0, ret.length() - 5); // Remove last AND;
	}

}
