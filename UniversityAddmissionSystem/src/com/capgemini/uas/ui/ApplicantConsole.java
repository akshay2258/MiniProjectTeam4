package com.capgemini.uas.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.capgemini.uas.dto.ApplicationBean;
import com.capgemini.uas.dto.ProgramScheduledBean;
import com.capgemini.uas.exception.UniversityException;
import com.capgemini.uas.service.ApplicantServiceImpl;
import com.capgemini.uas.service.IApplicantService;
public class ApplicantConsole {
	
	private IApplicantService appService;
	private Scanner sc;
	private DateTimeFormatter format;
	
	public void start() throws UniversityException {
		boolean flag=true,flag1=true,flag2=true,flag3=true,flag4=true;
		String fullName,dob,highestQualification;
		LocalDate dateOfBirth = null,dateOfInterview=null;
		int marksObtained,choice,applicationId = 0;
			
			appService = new ApplicantServiceImpl();
			sc = new Scanner(System.in);
		do											//do-while loop
			{
				System.out.println("Choose an operation");
				System.out.println("1. Program Scheduled");
				System.out.println("2. Apply Online");
				System.out.println("3. Application Status");
				System.out.println("4. Exit");
				System.out.println("******************************");
				System.out.print("\nPlease Enter a Choice : ");
				choice = sc.nextInt();
				System.out.println("\n******************************");
		List<ProgramScheduledBean> programScheduled= null;
		switch (choice) {
		
		case 1:
				programScheduled = appService.showProgramScheduled();
		    for (ProgramScheduledBean pBean : programScheduled) {
				System.out.println(pBean);
			}
			break;
		case 2:
			fullName=sc.nextLine();
		do
		{
			System.out.println("Enter Full Name as per 10th Crtificate"); 
			fullName=sc.nextLine();
			flag = ApplicantServiceImpl.validateFullName(fullName);
			if(flag==false)
				System.out.println("Name should be entered less than 20 character and first letter is capital");	
		}while(flag==false);
		do
		{
		System.out.println("Enter Date of Birth");
		dob = sc.next();
		flag1=ApplicantServiceImpl.validateDateOfBirth(dob);
		if(flag1==false)
			System.out.print("");
		}while(flag1==false);
		
		format = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		dateOfBirth = LocalDate.parse(dob,format);
		//System.out.println(dateOfBirth);
		//Customer Phone Number
		do
		{
			System.out.println("Enter your Highest Quailification : ");
			highestQualification = sc.next();
			flag2=ApplicantServiceImpl.validateHighestQualification(highestQualification);
			if(flag2==false)
				System.out.println("Length should be less than 10");
		}while(flag2==false);
		do
		{
			System.out.println("Enter your marks");
			marksObtained = sc.nextInt();
			if(flag3==false)
				System.out.println("Marks should be in proper format");
			}while(flag3==false);
		
			String goals;
			do {
				System.out.println("Define your goals");
				goals = sc.next();
				flag4=ApplicantServiceImpl.validateGoal(goals);
				if(flag4==false)
					System.out.println("Length should be less than 20");
			} while (flag4==false);
		System.out.println("Enter your Email Id");
		String emailId = sc.next();
		while(!ApplicantServiceImpl.validateEmail(emailId)){
			System.out.println("Enter your Correct Email Id");
			emailId = sc.next();
		}
		System.out.println("Please see below programs");
		
		programScheduled = appService.showProgramScheduled();
		if(programScheduled.isEmpty()){
			System.out.println("No Program Available");
			continue;
		}
	    for (ProgramScheduledBean pBean : programScheduled) {
			System.out.println(pBean);
		}
	    String scheduledProgramId;
	    do
		{
			System.out.println("Enter Program Scheduled Id from the above table:");
			scheduledProgramId = sc.next();
		}while(flag4==false);
	    
	    ApplicationBean applicantBean = new ApplicationBean();
	    applicantBean.setFullName(fullName);
	    applicantBean.setDateOfBirth(dateOfBirth);
	    applicantBean.setHighestQualification(highestQualification);
	    applicantBean.setMarksObtained(marksObtained);
	    applicantBean.setGoals(goals);
	    applicantBean.setEmailId(emailId);
	    applicantBean.setScheduledProgramId(scheduledProgramId);
		dateOfInterview = LocalDate.parse("2012-12-12");
	    applicantBean.setDateOfInterview(dateOfInterview);
				applicationId  = appService.addDetail(applicantBean);
	    System.out.println("Successfully applied. Your Application Id is : " + applicationId);
	   break;
	   
		case 3:
			do {
				System.out.println("Enter your Application Id");
				try {
					applicationId = sc.nextInt();
					applicantBean = appService.showStatus(applicationId);
					if (applicantBean!=null) {
						flag4=true;
						LocalDate checkDoi = LocalDate.parse("2012-12-12");
						if (applicantBean.getDateOfInterview().equals(checkDoi)) {
							System.out.println("Status : "
									+ applicantBean.getStatus());
						} else {
							System.out.println("Status : "
									+ applicantBean.getStatus());
							System.out.println("Date of Interview : "
									+ applicantBean.getDateOfInterview());
						}
					}else{
						flag4=true;
						System.out.println("No data Found");
					}
				} catch (Exception e) {
					flag4=false;
					System.out.println("Only Interger allowed and length should be less than 10");
					String dummy = sc.nextLine();
				}
			} while (flag4==false);
			
			
	}
			}while(choice!=4);
}
}
