package com.avishek.daofactory;

import com.avishek.persistence.IStudentDao;
import com.avishek.persistence.StudentDaoImpl;

public class StudentDaoFactory {

	private StudentDaoFactory() {}
	
	private static IStudentDao studentDao = null;
	
	public static IStudentDao getStudentDao() {
		if(studentDao == null) {
			studentDao = new StudentDaoImpl();
		}
		return studentDao;
	}
}
