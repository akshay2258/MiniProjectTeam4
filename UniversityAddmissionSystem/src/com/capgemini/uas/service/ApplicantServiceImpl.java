package com.capgemini.uas.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.capgemini.uas.dao.ApplicantDaoImpl;
import com.capgemini.uas.dao.IApplicantDao;
import com.capgemini.uas.dto.ApplicationBean;
import com.capgemini.uas.dto.ProgramScheduledBean;
import com.capgemini.uas.exception.UniversityException;

public class ApplicantServiceImpl implements IApplicantService {
	private IApplicantDao appDao;
	
	private static String patName = "[A-Z][A-Za-z ]{2,19}";
	private static String patDob = "[0-9]{2}-[0-9]{2}-[0-9]{4}";
	private static String patQual = "[0-9A-Za-z]{1,10}";
	private static String patGoal = "[0-9A-Za-z]{1,20}";
//	private static String patEmail = "";
	
	
	
	
	public ApplicantServiceImpl() throws UniversityException {
		appDao = new ApplicantDaoImpl();
	}
	
	public static boolean validateFullName(String fullName){
		return fullName.matches(patName);
	}

	public static boolean validateDateOfBirth(String dateOfBirth){
		LocalDate dob;
		if(dateOfBirth.matches(patDob)){
			try {
				DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				dob = LocalDate.parse(dateOfBirth,format);
				return true;
			} catch (Exception e) {
				return false;
			}
			
		}else{
			return false;
		}
	}
	
	public static boolean validateHighestQualification(String highestQualification){
		return highestQualification.matches(patQual);
	}
	
	public static boolean validateGoal(String goal){
		return goal.matches(patGoal);
	}
	@Override
	public List<ProgramScheduledBean> showProgramScheduled()
			throws UniversityException {
		// TODO Auto-generated method stub
		return appDao.showProgramScheduled();
	}

	@Override
	public int addDetail(ApplicationBean ab) throws UniversityException {
		// TODO Auto-generated method stub
		return appDao.addDetail(ab);
	}

	@Override
	public ApplicationBean showStatus(int applicationId)
			throws UniversityException {
		// TODO Auto-generated method stub
		return appDao.showStatus(applicationId);
	}

}
