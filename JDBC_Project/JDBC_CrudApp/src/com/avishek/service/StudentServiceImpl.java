package com.avishek.service;

import com.avishek.dto.Student;
import com.avishek.servicefactory.StudentServiceFactory;

//Service layer logic
public class StudentServiceImpl implements IStudentService {

	IStudentService stdService;
	
	@Override
	public String addStudent(String sname, Integer sage, String saddress) {
		stdService = StudentServiceFactory.getStudentService();
		return stdService.addStudent(sname, sage, saddress);
	}

	@Override
	public Student searchStudent(Integer sid) {
		return null;
	}

	@Override
	public String updateStudent(Integer sid, String sname, Integer sage, String saddress) {
		return null;
	}

	@Override
	public String deleteStudent(Integer sid) {
		return null;
	}

}
