package com.avishek.service;

import com.avishek.daofactory.StudentDaoFactory;
import com.avishek.dto.Student;
import com.avishek.persistence.IStudentDao;
import com.avishek.servicefactory.StudentServiceFactory;

//Service layer logic
public class StudentServiceImpl implements IStudentService {

	private IStudentDao stdDao;
	
	@Override
	public String addStudent(String sname, Integer sage, String saddress) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.addStudent(sname, sage, saddress);
	}

	@Override
	public Student searchStudent(Integer sid) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.searchStudent(sid);
	}

	@Override
	public String updateStudent(Integer sid, String sname, Integer sage, String saddress) {
		return null;
	}

	@Override
	public String deleteStudent(Integer sid) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.deleteStudent(sid);
	}

}
