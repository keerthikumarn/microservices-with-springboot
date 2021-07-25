package com.springboot.students.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.students.entity.Student;
import com.springboot.students.service.StudentService;
import com.springboot.students.vo.StudentVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/")
	public Student saveStudent(@RequestBody Student student) {
		log.info("Inside saveStudent of StudentController");
		return studentService.saveStudent(student);
	}
	
	@GetMapping("/{id}")
	public StudentVO getStudentWithCourse(@PathVariable("id") Long userId) {
		log.info("Inside getUserWithDepartment of UserController");
        return studentService.getStudentWithCourse(userId);
    } 

}
