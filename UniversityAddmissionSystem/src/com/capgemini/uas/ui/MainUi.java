package com.capgemini.uas.ui;

import java.util.Scanner;

import com.capgemini.uas.clientinterface.ApplicantUi;
import com.capgemini.uas.clientinterface.MacUi;
import com.capgemini.uas.dto.UsersBean;
import com.capgemini.uas.exception.UniversityException;
import com.capgemini.uas.service.IMacService;
import com.capgemini.uas.service.MacServiceImpl;

public class MainUi {

	public static void main(String[] args) {
		int choice;
		String loginId, password;
		boolean flag,flag1,flag2;
		try {
			IMacService macService = new MacServiceImpl();
			do											//do-while loop
			{
				System.out.println("\n*************University Addmission System *************");
				System.out.println("Choose an operation");
				System.out.println("1. Enter as a Admin");
				System.out.println("2. Enter as a MAC");
				System.out.println("3. Enter as a Applicant");
				System.out.println("4. Exit");
				System.out.println("******************************");
				System.out.print("\nPlease Enter a Choice : ");
				Scanner sc = new Scanner(System.in);
				choice = sc.nextInt();
				System.out.println("\n******************************");
				switch(choice)
				{
				
				
					case 1 :
						do {
							System.out.println("Enter User Name");
							loginId = sc.next();
							System.out.println("Enter Password");
							password = sc.next();
							UsersBean userBeanMain = new UsersBean(loginId, password,"admin");
							flag1 = macService.checkMacUser(userBeanMain);
							if(flag1==false)
								System.out.println("Wrong Crendential!! Not a valid Admin..Please enter correctly");
							} while (flag1==false);
						System.out.println("Welcome Admin To University Addmission Portal");
						break;
					case 2:  
						do {
							System.out.println("Enter User Name");
							loginId = sc.next();
							System.out.println("Enter Password");
							password = sc.next();
							UsersBean userBeanMain = new UsersBean(loginId, password,"mac");
							flag1 = macService.checkMacUser(userBeanMain);
							if(flag1==false)
								System.out.println("Wrong Crendential!! Not a valid MAC user..Please enter correctly");
							} while (flag1==false);
						System.out.println("Welcome Member of Addmission Commitee To University Addmission Portal");
						MacUi.main(args);
						break;
					case 3: { 
							System.out.println("Welcome Applicant to University Addmission System");
							ApplicantUi.main(args);
						break;
					}
					case 4: {
						System.out.println("Thanks for Visiting!!!!");
						break;
					}
					} 
				
			}while(choice!=5);
		} catch(UniversityException e) {
			
		}
	}
}
