package com.epam.prelearning.studentmanagement;

import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class StudentHandler 
{
	private ArrayList<Student> studentList;
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
	
	public void sortStudent()
	{
		Scanner inputScanner = new Scanner(System.in);
		SortStudent sortStudent = new SortStudent();
		System.out.println("--- Select an Sorting Option --");
		System.out.println("1. Student ID\t 2. Branch\t 3.Year");
		System.out.print("Enter your option: ");
		int userChoice = inputScanner.nextInt();
		switch(userChoice)
		{
			case 1:	studentList = sortStudent.sortByID(studentList);		break;
			case 2:	studentList = sortStudent.sortByBranch(studentList);	break;
			case 3: studentList = sortStudent.sortByYear(studentList);		break;
			default:	System.out.println("Invalid Choice!"); 				break;
		}
		displayStudent();
		
	}
	
	public void searchStudent()
	{
		Scanner inputScanner = new Scanner(System.in);
		SearchStudent searchStudent = new SearchStudent();
		System.out.println("--- Select an Searching Option --");
		System.out.println("1. Student ID\t 2. Student Name\t 3. Branch\t 4.Year");
		System.out.print("Enter your option: ");
		int userChoice = inputScanner.nextInt();
		ArrayList<Student> studentFoundList = new ArrayList<Student>();
		switch(userChoice)
		{
			case 1:		System.out.print("Enter the Student ID: ");
						int studentID = inputScanner.nextInt();
						studentFoundList = searchStudent.searchByID(studentList, studentID);		
						break;
						
			default:	System.out.println("Invalid Choice!"); 						break;
			
			/*case 2:	studentList = sortStudent.sortByBranch(studentList);	break;
			case 3: studentList = sortStudent.sortByYear(studentList);		break;
			default:	System.out.println("Invalid Choice!"); 				break;
			*/
		}
		
		if(studentFoundList.size()==0)
			System.out.println("--- Student Not Found ---");
		else
			displayStudent(studentFoundList);
	}
	
	
}
