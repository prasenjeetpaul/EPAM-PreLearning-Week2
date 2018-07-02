/**
 * SearchStudent.java
 * v 1.0
 * This java file contains the code to search a particular user record or 
 * list of user record based on the user input
 */

package com.epam.prelearning.studentmanagement;

import java.util.ArrayList;

public class SearchStudent
{
	/* This method searches a student record based on student ID */
	public ArrayList<Student> searchByID(ArrayList<Student> studentList, int studentID)
	{
		ArrayList<Student> studentFoundList = new ArrayList<Student> ();
		for(Student currentStudent: studentList)
		{
			if(currentStudent.getID() == studentID)
				studentFoundList.add(currentStudent);
			
		}
		
		return studentFoundList;
	}
	
	/* This method searches a student record based on student name */
	public ArrayList<Student> searchByName(ArrayList<Student> studentList, String studentName)
	{
		ArrayList<Student> studentFoundList = new ArrayList<Student> ();
		for(Student currentStudent: studentList)
		{
			String firstName = currentStudent.getFirstName().toLowerCase();
			String lastName = currentStudent.getLastName().toLowerCase();
			if(	studentName.contains(firstName) || studentName.contains(lastName) || firstName.contains(studentName) || lastName.contains(studentName))
				studentFoundList.add(currentStudent);
			
		}
		
		return studentFoundList;
	}
	
	
	/* This method searches a student record based on student branch */
	public ArrayList<Student> searchByBranch(ArrayList<Student> studentList, String studentBranch)
	{
		ArrayList<Student> studentFoundList = new ArrayList<Student> ();
		for(Student currentStudent: studentList)
		{
			String currentStudentBranch = currentStudent.getBranch().toLowerCase();
			if(	currentStudentBranch.contains(studentBranch) || studentBranch.contains(currentStudentBranch) )
				studentFoundList.add(currentStudent);
			
		}
		
		return studentFoundList;
	}
	
	/* This method searches a student record based on student year */
	public ArrayList<Student> searchByYear(ArrayList<Student> studentList, int studentYear)
	{
		ArrayList<Student> studentFoundList = new ArrayList<Student> ();
		for(Student currentStudent: studentList) 
		{
			if(	currentStudent.getYear() == studentYear  )
				studentFoundList.add(currentStudent);
			
		}
		
		return studentFoundList;
	}
	

}
