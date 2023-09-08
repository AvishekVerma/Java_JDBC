package com.avishek.controller;

import java.util.Scanner;

import com.avishek.dto.Student;
import com.avishek.service.IStudentService;
import com.avishek.servicefactory.StudentServiceFactory;

//Controller logic
public class TestApp {

	public static void main(String[] args) {
		
//		insertoperation();
//		selectOperation();
		
		deleteRecord();
		
	}

	private static void deleteRecord() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the student id to be deleted :: ");
		int sid = sc.nextInt();
		
		IStudentService studentService = StudentServiceFactory.getStudentService();
		String msg = studentService.deleteStudent(sid);
		
		if(msg.equalsIgnoreCase("success")) {
			System.out.println("Record deleted successfully");
		}else if(msg.equalsIgnoreCase("not found")){
			System.out.println("Record not avilable for the given id :: "+sid);
		}else {
			System.out.println("Record delation failed...");
		}
		
		sc.close();
	}

	private static void selectOperation() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the student id :: ");
		int sid = sc.nextInt();

		IStudentService studentService = StudentServiceFactory.getStudentService();
		Student std = studentService.searchStudent(sid);
		if (std != null) {
			System.out.println(std);
			System.out.println("Id\tNAME\tAGE\tADDRESS");
			System.out.println(std.getSid() + "\t" + std.getSname() + "\t" + std.getSage() + "\t" + std.getSaddress());
		} else {
			System.out.println("Record not found for the given id :: " + sid);
		}
		sc.close();
	}

	private static void insertoperation() {
		// Connection connection = DriverManager.getConnection(url,username,password);
		IStudentService studentService = StudentServiceFactory.getStudentService();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the student name :: ");
		String sname = sc.next();
		
		System.out.println("Enter the student age :: ");
		int sage = sc.nextInt();
		
		System.out.println("Enter the student address :: ");
		String saddress = sc.next();
		
		String msg = studentService.addStudent(sname, sage, saddress);
		if(msg.equalsIgnoreCase("success")) {
			System.out.println("Record inserted successfully");
		}else {
			System.out.println("Record insertion failed...");
		}
		
		sc.close();
	}

}
