package user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Dao.Dao;
import Dao.IMapper;
import user.domain.User;

/**
 * DDL functions performed in database
 * @author changxin bai
 *
 */
public class UserDao extends Dao<User, String> {
	
	private static IMapper<User> USER_MAPPER = new IMapper<User>(){
		@Override
		public User map(ResultSet resultSet) throws SQLException{
			User user = new User();
			
    		user.setUsername(resultSet.getString("username"));
    		user.setPassword(resultSet.getString("password"));
    		user.setEmail(resultSet.getString("email"));
			
			return user;			
		}
	};
	
	public UserDao() {
		super(USER_MAPPER, User.class);
	}	
	
	/**
	 * get the search result with username 
	 * @param username
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public User findByUsername(String username) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		List<User> users = select("select * from tb_user where username=?", username);
		
		if(users.isEmpty()){		
			return new User();
		}else{
			return users.get(0);
		}
	}
	
	/**
	 * insert User
	 * @param user
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void add(User user) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		update("insert into tb_user values(?,?,?)", user.getUsername(), user.getPassword(), user.getEmail());
	}
	
	public List<User> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return select("select * from tb_user");
	}
}
