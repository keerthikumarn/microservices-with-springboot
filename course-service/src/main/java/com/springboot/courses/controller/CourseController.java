package com.springboot.courses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.courses.entity.Course;
import com.springboot.courses.service.CourseService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@PostMapping("/")
	public Course saveCourse(@RequestBody Course course) {
		log.info("Inside saveCourse of CourseController");
		return courseService.saveCourse(course);
	}

	@GetMapping("/{id}")
	public Course findCourseByCourseId(@PathVariable("id") Long courseId) {
		log.info("Inside findCourseByCourseId method of CourseController");
		return courseService.findCourseByCourseId(courseId);
	}

}
