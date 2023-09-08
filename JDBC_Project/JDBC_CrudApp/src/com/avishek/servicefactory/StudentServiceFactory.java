package com.avishek.servicefactory;

import com.avishek.service.IStudentService;
import com.avishek.service.StudentServiceImpl;

// Connectin connection = DriverManager.getConnection(url,username,password);

//Abstraction logic of implementation 
public class StudentServiceFactory {
	
	//make constructor private to avoid object creation
	private StudentServiceFactory() {
		
	}

	private static IStudentService studentService = null;
	
	public static IStudentService getStudentService() {
		
		// singleton pattern code
		if(studentService == null) {
			studentService = new StudentServiceImpl();
		}
		return studentService;
	}
}
