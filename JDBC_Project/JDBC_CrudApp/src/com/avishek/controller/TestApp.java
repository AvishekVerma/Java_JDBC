package com.avishek.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.avishek.dto.Student;
import com.avishek.service.IStudentService;
import com.avishek.servicefactory.StudentServiceFactory;

//Controller logic
public class TestApp {

	public static void main(String[] args) throws IOException {
		
//		insertoperation();
//		selectOperation();
//		deleteRecord();
		
		updateOperation();
		
	}

	private static void updateOperation() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the student id to be update :: ");
		String sid = br.readLine();

		IStudentService studentService = StudentServiceFactory.getStudentService();
		Student student = studentService.searchStudent(Integer.parseInt(sid));

		if (student != null) {
			Student newStudent = new Student();

			System.out.println("Student id is :: " + student.getSid());
			newStudent.setSid(student.getSid());

			System.out.println("Student oldName is :: " + student.getSname() + " Enter newName :: ");
			String newName = br.readLine();
			if (newName.equals("") || newName == "") {
				newStudent.setSname(student.getSname());
			} else {
				newStudent.setSname(newName);
			}

			System.out.println("Student oldAge is :: " + student.getSage() + " Enter newAge :: ");
			String newAge = br.readLine();
			if (newAge.equals("") || newAge == "") {
				newStudent.setSage(student.getSage());
			} else {
				newStudent.setSage(Integer.parseInt(newAge));
			}

			System.out.println("Student oldAddress is :: " + student.getSaddress() + " Enter newAddress :: ");
			String newAddress = br.readLine();
			if (newAddress.equals("") || newAddress == "") {
				newStudent.setSaddress(student.getSaddress());
			} else {
				newStudent.setSaddress(newAddress);
			}
			
			System.out.println("New Object data is :: "+newStudent);
			System.out.println();

			String status = studentService.updateStudent(newStudent);

			if (status.equalsIgnoreCase("success")) {
				System.out.println("Record updated successfully");
			} else {
				System.out.println("Record updation failed...");
			}
		} else {
			System.out.println("Student record not available for the given id " + sid + "for updation...");
		}

		br.close();
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
