package com.crs.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crs.www.entity.Student;
import com.crs.www.repository.IStudentRepository;

@Service("stdservice")
public class StudentManagementServiceImpl implements IStudentManagementService {

	@Autowired
	private IStudentRepository stdRepo;
	public Iterable<Student> showAllStudent() {
		// TODO Auto-generated method stub
		return stdRepo.findAll();
	}
	@Override
	public String registerStudent(Student stud) {
		// TODO Auto-generated method stub
		return "Student is saved with id value"+stdRepo.save(stud).getStdNo();
	}
	@Override
	public Student getStudentByNo(int sno) {
		// TODO Auto-generated method stub
		Student std=stdRepo.findById(sno).orElseThrow(()->new IllegalArgumentException());
		return std;
	}
	@Override
	public String updateStudent(Student std) {
		// TODO Auto-generated method stub
		return "Stduent is updated with having id value"+stdRepo.save(std).getStdNo();
	}
	@Override
	public String deleteStudentById(int sno) {
		// TODO Auto-generated method stub
		stdRepo.deleteById(sno);
		return sno+" student id Student is deleted";
	}
}
