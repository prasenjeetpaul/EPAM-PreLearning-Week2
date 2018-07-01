package com.epam.prelearning.studentmanagement;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main 
{

	static final int SEARCH_OPTION = 1;
	static final int SORT_OPTION = 2;
	static final int DISPLAY_OPTION = 3;
	static final int EXIT_OPTION = 4;
	
	
	public static void main(String[] args)
	{
		boolean programStaus = true;
		System.out.println("********** Welcome to Student Management System **********");
		StudentHandler studentHandler = new StudentHandler();
		while(programStaus)
		{
			int userChoice = getUserChoice();
			switch(userChoice)
			{
				case SEARCH_OPTION: 	studentHandler.searchStudent();		break;
				case SORT_OPTION:		studentHandler.sortStudent();		break;
				case DISPLAY_OPTION:	studentHandler.displayStudent();	break;
				case EXIT_OPTION:		programStaus = false;				break;
				
				default:	System.out.println("Invalid Choice!");	break;
			}
		}
		System.out.println("******************** Program Exited **********************");
	}
	
	public static int getUserChoice()
	{
		@SuppressWarnings("resource")
		Scanner inputScanner = new Scanner(System.in);
		int userChoice = -1;
		
		try
		{
			System.out.println("********************* Program Menu ***********************");
			System.out.println( SEARCH_OPTION+". Search Student\t "+
								SORT_OPTION+". Sort Students\t "+
								DISPLAY_OPTION+". Display Students\t "+
								EXIT_OPTION+". Exit");
			System.out.print("Enter your choice: ");
			userChoice = inputScanner.nextInt();
		}
		catch(InputMismatchException e)
		{
			System.out.println("Please enter only the option number!");
		}
		
		return userChoice;
	}

}