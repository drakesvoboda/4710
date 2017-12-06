package Models.PCMember;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Dao.Dao;
import Dao.IMapper;
import Models.PCMember.PCMember;

public class PCMemberDao extends Dao<PCMember, Integer> {
	
	private static IMapper<PCMember> PCMEMBER_MAPPER = new IMapper<PCMember>(){
		@Override
		public PCMember map(ResultSet resultSet) throws SQLException{
			PCMember pcMember = new PCMember();
			
			pcMember.setEmail(resultSet.getString("email"));
			pcMember.setMemberName(resultSet.getString("memberName"));
			pcMember.setId(resultSet.getInt("PCmemberID"));
			
			return pcMember;			
		}
	};
	
	public PCMemberDao() {
		super(PCMEMBER_MAPPER, PCMember.class);
	}		
	
	public List<PCMember> getReviewersForPaper(int PaperID){
		return select("SELECT * FROM PCMember P WHERE P.pcmemberid IN (SELECT pcmemberid FROM review R WHERE R.PaperID = ?)", PaperID);
	}

}
