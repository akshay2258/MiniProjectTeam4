package com.capgemini.uas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.capgemini.uas.dto.ProgramOfferedBean;
import com.capgemini.uas.exception.UniversityException;
import com.capgemini.uas.util.ConnectionUtil;

public class AdminDaoImpl implements IAdminDao {
	private Connection connect;
	@Override
	public boolean addProgramOffered(ProgramOfferedBean pOffered)
			throws UniversityException {
		
		int recsAffected=0;
		
		ConnectionUtil util = new ConnectionUtil();
		connect = util.getConnection();
		PreparedStatement stmt = null;
		try{
			stmt = connect.prepareStatement(IQueryMapper.ADD_PROGRAM);
			stmt.setString(1,pOffered.getProgramName());
			stmt.setString(2,pOffered.getDescription());
			 //to convert date of birth local date to sql date
			stmt.setString(3,pOffered.getApplicantEligiblity());
			stmt.setInt(4,pOffered.getDuration());
			stmt.setString(5,pOffered.getDegreeCertificate());
			
			recsAffected= stmt.executeUpdate();
			}catch(SQLException e){
				e.printStackTrace();
				throw new UniversityException("Problem in writing data in programOffered",e);
			}finally {
					try {
						if (connect != null) {
							stmt.close();
							connect.close();
						}
					} catch (Exception e) {
						e.printStackTrace();
						throw new UniversityException(
						"Could not close the connection in programOffered");
					}
			}
		if(recsAffected==1)
		{
			return true;
	}
		else
		return false;
	}

	
	@Override
	public boolean deleteProgramOffered(String programName)
			throws UniversityException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addProgramScheduled(String programName)
			throws UniversityException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProgramScheduled(String programId)
			throws UniversityException {
		// TODO Auto-generated method stub
		return false;
	}

}
