package com.crs.www.service;

import com.crs.www.entity.Student;

public interface IStudentManagementService {
	

	public Iterable<Student> showAllStudent();
	public String registerStudent(Student stud);
	public Student getStudentByNo(int sno);
	public String updateStudent(Student std);
	public String deleteStudentById(int sno);

}
