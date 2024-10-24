package com.crs.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crs.www.entity.Student;

public interface IStudentRepository extends JpaRepository<Student, Integer> {

}
