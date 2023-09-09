package com.avishek.service;

import com.avishek.dto.Student;

public interface IStudentService {

	//Operations to be implemented
	public String addStudent(String name,Integer sage,String saddress);
		
	public Student searchStudent(Integer sid);
		
	public String updateStudent(Student student);
		
	public String deleteStudent(Integer sid);
		
}
