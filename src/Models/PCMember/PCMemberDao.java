package Models.PCMember;

import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.Dao;
import Dao.IMapper;
import Models.PCMember.PCMember;

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
	
	public PCMemberDao() {
		super(PCMEMBER_MAPPER);
	}		

}
