package com.capgemini.uas.ui;

import java.util.Scanner;

import com.capgemini.uas.clientinterface.ApplicantUi;

public class MainUi {

	public static void main(String[] args) {
		int choice;
		String loginId, password;
		boolean flag,flag1,flag2;
			do											//do-while loop
			{
				System.out.println("\n*************University Addmission System *************");
				System.out.println("Choose an operation");
				System.out.println("1. Enter as a Admin");
				System.out.println("2. Enetr as a MAC");
				System.out.println("3. Enter as a Applicant");
				System.out.println("4. Exit");
				System.out.println("******************************");
				System.out.print("\nPlease Enter a Choice : ");
				Scanner sc = new Scanner(System.in);
				choice = sc.nextInt();
				System.out.println("\n******************************");
				
				switch(choice)
				{
				
				
					case 1 :// Add Customer Information
						{
							int patientId;
							System.out.println("Enter User Name");
							loginId = sc.next();
							System.out.println("Enter Password");
							password = sc.next();
							
							break;
						}
					case 2: { 
						int patientId;
						System.out.println("Enter User Name");
						loginId = sc.next();
						System.out.println("Enter Password");
						password = sc.next();
						}
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
	}
}
