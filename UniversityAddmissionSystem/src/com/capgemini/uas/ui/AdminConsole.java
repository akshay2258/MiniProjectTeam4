package com.capgemini.uas.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.uas.dto.ApplicationBean;
import com.capgemini.uas.dto.ProgramOfferedBean;
import com.capgemini.uas.exception.UniversityException;
import com.capgemini.uas.service.AdminServiceImpl;
import com.capgemini.uas.service.IAdminService;

public class AdminConsole {
	String userName;
	IAdminService service;
	
	public AdminConsole(String userName) {
		super();
		this.userName = userName;
	}
	
	public void start() throws UniversityException {
		int choice;
		String scheduledProgramId;
		service = new AdminServiceImpl();
		Scanner sc;
			sc = new Scanner(System.in);
			do											//do-while loop
			{
				System.out.println("Welcome "+userName);
				System.out.println("Choose an operation");
				System.out.println("1. View list of applicants of particular program scheduled");
				System.out.println("2. View list of applicants of particular program scheduled after interview");
				System.out.println("3. Add program Offered");
				System.out.println("4. Back to Home Page");
				System.out.println("******************************");
				System.out.print("\nPlease Enter a Choice : ");
				choice = sc.nextInt();
				System.out.println("\n******************************");
				List<ApplicationBean> applicantDetails = new ArrayList<ApplicationBean>();
				switch (choice) {
				case 1:
					System.out.println("Enter Program Scheduled Id");
					scheduledProgramId = sc.next();
					//applicantDetails = macService.getApplicantsOnSchduledId(scheduledProgramId);
					 for (ApplicationBean applicants : applicantDetails) {
							System.out.println(applicants);
						}
					break;

				case 2:
					System.out.println("Enter Program Scheduled Id");
					scheduledProgramId = sc.next();
					//applicantDetails = macService.getApplicantsAfterInterviewOnId(scheduledProgramId);
					for (ApplicationBean applicants : applicantDetails) {
						System.out.println(applicants);
					}
					break;
					
				case 3:
					System.out.println("Enter Program offered details to add: ");
					ProgramOfferedBean pOffered=new ProgramOfferedBean() ;
					System.out.println("Enter Program Name:");
					pOffered.setProgramName(sc.next());
					System.out.println("Enter Program Description");
					pOffered.setDescription(sc.next());
					System.out.println("Enter Program Eligibilty");
					pOffered.setApplicantEligiblity(sc.next());
					System.out.println("Enter Program duration");
					pOffered.setDuration(sc.nextInt());
					System.out.println("Enter Program degree Certificate offered");
					pOffered.setDegreeCertificate(sc.next());
					service.addProgramOffered(pOffered);
					break;
				case 4:
					System.out.println("Thanks For Visiting..");
					break;
				}
}while(choice!=4);
		
	}
}
