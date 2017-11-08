package Models.PCMember;

import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.Dao;
import Dao.IMapper;
import Models.PCMember.PCMember;
import MySqlAnnotations.MySqlAnnotationNotFoundException;

public class PCMemberDao extends Dao<PCMember, String> {
	
	private static IMapper<PCMember> PCMEMBER_MAPPER = new IMapper<PCMember>(){
		@Override
		public PCMember map(ResultSet resultSet) throws SQLException{
			PCMember pcMember = new PCMember();
			
			pcMember.setEmail(resultSet.getString("email"));
			pcMember.setMemberName(resultSet.getString("memberName"));
			
			return pcMember;			
		}
	};
	
	public PCMemberDao() throws MySqlAnnotationNotFoundException {
		super(PCMEMBER_MAPPER, PCMember.class);
	}		

}
