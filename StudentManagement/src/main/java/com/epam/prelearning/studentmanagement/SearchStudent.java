package com.epam.prelearning.studentmanagement;

import java.util.ArrayList;

public class SearchStudent
{
	
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
	/*
	public ArrayList<Student> sortByBranch(ArrayList<Student> studentList)
	{
		for(int i=0; i<studentList.size(); i++)
		{
			for(int j=i+1; j<studentList.size(); j++)
			{
				if(studentList.get(i).getBranch().compareTo(studentList.get(j).getBranch())>0)
				{
					Student temp = studentList.get(i);
					studentList.set(i, studentList.get(j));
					studentList.set(j, temp);
				}
			}
			
			
			
		}
		System.out.println("Student Data Sorted According to Branch !!");
		return studentList;
	}
	
	public ArrayList<Student> sortByYear(ArrayList<Student> studentList)
	{
		for(int i=0; i<studentList.size(); i++)
		{
			int min = Integer.MAX_VALUE;
			int minStudentIndex=i;
			for(int j=i+1; j<studentList.size(); j++)
			{
				if(studentList.get(j).getYear()<studentList.get(minStudentIndex).getYear())
					minStudentIndex = j; 
			}
			
			Student temp = studentList.get(i);
			studentList.set(i, studentList.get(minStudentIndex));
			studentList.set(minStudentIndex, temp);
			
		}
		System.out.println("Student Data Sorted According to Year !!");
		return studentList;
	}
	*/

}
