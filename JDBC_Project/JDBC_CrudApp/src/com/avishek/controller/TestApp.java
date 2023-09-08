package com.avishek.controller;

import com.avishek.service.IStudentService;
import com.avishek.servicefactory.StudentServiceFactory;

//Controller logic
public class TestApp {

	public static void main(String[] args) {
		
		// Connection connection = DriverManager.getConnection(url,username,password);
		IStudentService studentService = StudentServiceFactory.getStudentService();
		String msg = studentService.addStudent("Sachin", 49, "MI");
		if(msg.equalsIgnoreCase("success")) {
			System.out.println("Record inserted successfully");
		}else {
			System.out.println("Record insertion failed...");
		}
	}

}
