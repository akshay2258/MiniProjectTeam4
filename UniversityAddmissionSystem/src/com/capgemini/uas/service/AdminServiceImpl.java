package com.capgemini.uas.service;

import com.capgemini.uas.dao.AdminDaoImpl;
import com.capgemini.uas.dao.IAdminDao;
import com.capgemini.uas.dto.ProgramOfferedBean;
import com.capgemini.uas.exception.UniversityException;

public class AdminServiceImpl implements IAdminService {
private IAdminDao dao;
public AdminServiceImpl()
{
	dao=new AdminDaoImpl();
}
	@Override
	public boolean addProgramOffered(ProgramOfferedBean pOffered)
			throws UniversityException {
		// TODO Auto-generated method stub
		return dao.addProgramOffered(pOffered);
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
