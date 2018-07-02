/**
 * StudentHandler.java
 * v 1.0
 * This java file handles the Student Management Operations.
 * It provides operations like load the student data and perform actions on it.
 */
package com.epam.prelearning.studentmanagement;

import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;

public class StudentHandler 
{
	private ArrayList<Student> studentList;
	private final String INVALID_INPUT_MESSAGE = "Invalid Input!!";
	private final int DEFAULT_USER_CHOICE = -1;
	
	/* This constructor load and stores the student data in runtime*/
	public StudentHandler()
	{
		final String studentDataPath = "src/main/resources/StudentData.txt";
		File file = new File(studentDataPath);
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String currentFileLine;
			studentList = new ArrayList<Student>();
			
			while((currentFileLine = br.readLine()) != null)
			{
				String currentStudentRecord[] = currentFileLine.split(",");
				
				int studentID = Integer.parseInt(currentStudentRecord[0].trim());
				String firstName = currentStudentRecord[1].trim();
				String lastName = currentStudentRecord[2].trim();
				String branch = currentStudentRecord[3].trim();				
				int year = Integer.parseInt(currentStudentRecord[4].trim());
				
				studentList.add(new Student(studentID, firstName, lastName, branch, year));
			}
			
			br.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/* This method displays the student record*/
	public void displayStudent()
	{
		List<String> headerList = new ArrayList<String>();
		Collections.addAll(headerList, "Student ID", "First Name", "Last Name", "Branch", "Year");
		List<List<String>> rowList = new ArrayList<List<String>>();
		for(Student currentStudent: this.studentList)
			rowList.add(currentStudent.getData());

		DisplayStudent display = new DisplayStudent();
		System.out.println(display.generateTable(headerList, rowList));
	}
	
	/* Overloaded method to display the student record*/
	public void displayStudent(ArrayList<Student> studentList)
	{
		List<String> headerList = new ArrayList<String>();
		Collections.addAll(headerList, "Student ID", "First Name", "Last Name", "Branch", "Year");
		List<List<String>> rowList = new ArrayList<List<String>>();
		for(Student currentStudent: studentList)
			rowList.add(currentStudent.getData());

		DisplayStudent display = new DisplayStudent();
		System.out.println(display.generateTable(headerList, rowList));
	}
	
	/* This method sorts the student data as per the user requirement*/
	public void sortStudent()
	{
		@SuppressWarnings("resource")
		Scanner inputScanner = new Scanner(System.in);
		SortStudent sortStudent = new SortStudent();
		int userChoice = DEFAULT_USER_CHOICE;
		
		System.out.println("\n------ Select an Sorting Option --");
		System.out.println("1. Student ID\t 2. Branch\t 3.Year");
		System.out.print("Enter your option: ");
		try
		{
			userChoice = inputScanner.nextInt();			
		}
		catch(InputMismatchException exception)
		{
			System.out.println(this.INVALID_INPUT_MESSAGE);
			return ;
		}
		SortOrder sortOrder = getSortingOrder();
		switch(userChoice)
		{
			case 1:		studentList = sortStudent.sortByID(studentList, sortOrder);		break;
			case 2:		studentList = sortStudent.sortByBranch(studentList, sortOrder);	break;
			case 3: 	studentList = sortStudent.sortByYear(studentList, sortOrder);		break;
			default:	System.out.println(this.INVALID_INPUT_MESSAGE); 		break;
		}
		displayStudent();
		
	}
	
	/* This method searches for a/list of student record and display it*/
	public void searchStudent()
	{
		@SuppressWarnings("resource")
		Scanner inputScanner = new Scanner(System.in);
		SearchStudent searchStudent = new SearchStudent();
		System.out.println("\n--- Select an Searching Option --");
		System.out.println("1. Student ID\t 2. Student Name\t 3. Branch\t 4.Year");
		System.out.print("Enter your option: ");
		int userChoice = DEFAULT_USER_CHOICE;
		try
		{
			userChoice = inputScanner.nextInt();
		}
		catch(InputMismatchException exception)
		{
			System.out.println(this.INVALID_INPUT_MESSAGE);
			return ;
		}
		ArrayList<Student> studentFoundList = new ArrayList<Student>();
		switch(userChoice)
		{
			case 1:	System.out.print("Enter Student ID: ");
					int studentID = inputScanner.nextInt();
					studentFoundList = searchStudent.searchByID(studentList, studentID);		
					break;
			
			case 2:	System.out.print("Enter Student Name (First Name/Last Name): ");
					inputScanner.nextLine();
					String studentName = inputScanner.nextLine();
					studentFoundList = searchStudent.searchByName(studentList, studentName.toLowerCase());		
					break;
					
			case 3: System.out.print("Enter Student Branch: ");
					inputScanner.nextLine();
					String studentBranch = inputScanner.nextLine();
					studentFoundList = searchStudent.searchByBranch(studentList, studentBranch.toLowerCase());		
					break;
			
			case 4: System.out.print("Enter Student Year: ");
					int studentYear = inputScanner.nextInt();
					studentFoundList = searchStudent.searchByYear(studentList, studentYear);		
					break;
					
			default:	System.out.println(this.INVALID_INPUT_MESSAGE); 
						break;
			
		}
		
		if(studentFoundList.size()==0)
			System.out.println("--- Student Not Found ---");
		else
			displayStudent(studentFoundList);
	}
	
	/* This method gets the sorting order from the user */
	private SortOrder getSortingOrder()
	{
		@SuppressWarnings("resource")
		Scanner inputScanner = new Scanner(System.in);
		SortOrder sortOrder = SortOrder.ASCENDING; 
		try
		{
			System.out.println("\n------ Select an Sorting Order --");
			System.out.println("1. Ascending Order\t 2. Descending Order");
			System.out.print("Enter your option: ");
			int sortChoice = inputScanner.nextInt();
			switch(sortChoice)
			{
				case 1:	sortOrder = SortOrder.ASCENDING;	break;
				case 2: sortOrder = SortOrder.DESCENDING;	break; 
				default: System.out.println(this.INVALID_INPUT_MESSAGE+"\nSorting in Ascending Order");	break;
			}
			
		}
		catch(InputMismatchException e)
		{
			sortOrder = SortOrder.ASCENDING;
			System.out.println(this.INVALID_INPUT_MESSAGE+"\nSorting in Ascending Order");
		}
		
		return sortOrder;
	}
	
	
}
