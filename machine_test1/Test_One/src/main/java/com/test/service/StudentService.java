package com.test.service;

import java.util.List;

import com.test.model.Student;

public interface StudentService {
	

	public  Student addStudent(Student cust);

	public Student removeStudent(Student cust) ;

	public Student updateStudent(Student cust) ;

	public List<Student> ViewAllStudent();

}
