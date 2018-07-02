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
	
	public Student(int id, String firstName, String lastName, String branch, int year)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.branch = branch;
		this.year = year;		
	}
	
	public int getID()
	{
		return this.id;
	}
	
	public String getFirstName()
	{
		return this.firstName;
	}
	
	public String getLastName()
	{
		return this.lastName;
	}
	
	public String getBranch()
	{
		return this.branch;
	}
	
	public int getYear()
	{
		return this.year;
	}
	
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
