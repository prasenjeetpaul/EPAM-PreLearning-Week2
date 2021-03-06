/**
 * Main.java
 * v 1.0
 * This file contains the main() method to start the execution of the program
 */

package com.epam.prelearning.studentmanagement;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{	
	static final int SEARCH_OPTION = 1;
	static final int SORT_OPTION = 2;
	static final int DISPLAY_OPTION = 3;
	static final int EXIT_OPTION = 4;
	static final int DEFAULT_USER_CHOICE = -1;
	
	/* Main method */
	public static void main(String[] args)
	{
		boolean programStaus = true;
		System.out.println("********** Welcome to Student Management System **********");
		StudentHandler studentHandler = new StudentHandler();
		while(programStaus)
		{
			int userChoice = getUserChoice();	//getting the user choice
			switch(userChoice)
			{
				case SEARCH_OPTION: 	studentHandler.searchStudent();		break;	//searching students
				case SORT_OPTION:		studentHandler.sortStudent();		break;	//sorting students
				case DISPLAY_OPTION:	studentHandler.displayStudent();	break;	//displaying students
				case EXIT_OPTION:		programStaus = false;				break;	//exit
				
				default:	System.out.println("Invalid Choice!");	break;
			}
		}
		System.out.println("******************** Program Exited **********************");
	}
	
	/* Method to get the user choice to perform further actions */
	public static int getUserChoice()
	{
		@SuppressWarnings("resource")
		Scanner inputScanner = new Scanner(System.in);	//scanner to take user inputs
		int userChoice = DEFAULT_USER_CHOICE;
		
		try
		{
			System.out.println("\n********************* Program Menu ***********************");
			System.out.println( SEARCH_OPTION+". Search Student\t "+
								SORT_OPTION+". Sort Students\t "+
								DISPLAY_OPTION+". Display Students\t "+
								EXIT_OPTION+". Exit");
			System.out.print("Enter your choice: ");
			userChoice = inputScanner.nextInt();	//getting the user input
		}
		catch(InputMismatchException e)
		{
			System.out.println("Please enter only the option number!");
		}
		
		return userChoice;
	}

}
