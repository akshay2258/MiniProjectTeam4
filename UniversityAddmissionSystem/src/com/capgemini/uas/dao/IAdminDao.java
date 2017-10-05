package com.capgemini.uas.dao;

import com.capgemini.uas.dto.ProgramOfferedBean;
import com.capgemini.uas.exception.UniversityException;

public interface IAdminDao {
	public boolean addProgramOffered(ProgramOfferedBean pOffered) throws UniversityException;
	public boolean deleteProgramOffered(String programName) throws UniversityException;
	public boolean addProgramScheduled(String programName) throws UniversityException;
	public boolean deleteProgramScheduled(String programId) throws UniversityException;
	
}
