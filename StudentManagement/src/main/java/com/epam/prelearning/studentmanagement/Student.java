/**
 * Student.java
 * v 1.0
 * This java file is used to maintain a student identity
 */

package com.epam.prelearning.studentmanagement;

import java.util.ArrayList;
import java.util.List;

public class Student 
{
	private int id;
	private String firstName;
	private String lastName;
	private String branch;
	private int year;
	
	/* Constructor that creates a new student with its attributes */
	public Student(int id, String firstName, String lastName, String branch, int year)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.branch = branch;
		this.year = year;		
	}
	
	/* Getter method to return student ID */
	public int getID()
	{
		return this.id;
	}
	
	/* Getter method to return student first name */
	public String getFirstName()
	{
		return this.firstName;
	}
	
	/* Getter method to return student last name */
	public String getLastName()
	{
		return this.lastName;
	}
	
	/* Getter method to return student branch */
	public String getBranch()
	{
		return this.branch;
	}
	
	/* Getter method to return student year */
	public int getYear()
	{
		return this.year;
	}
	
	/* Method to get the student data as a list */
	public List<String> getData()
	{
		List<String> studentData = new ArrayList<String>();
		studentData.add(this.id+"");
		studentData.add(this.firstName);
		studentData.add(this.lastName);
		studentData.add(this.branch);
		studentData.add(this.year+"");
		return studentData;
	}
	
}
