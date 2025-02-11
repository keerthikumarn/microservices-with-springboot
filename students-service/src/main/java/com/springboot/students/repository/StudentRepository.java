package com.springboot.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.students.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	public Student findByRegNo(Long regNo);

	public Student findByRegNoAndFirstName(Long regNo, String firstName);

}
