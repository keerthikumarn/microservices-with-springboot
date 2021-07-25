package com.springboot.courses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.courses.entity.Course;
import com.springboot.courses.repository.CourseRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public Course saveCourse(Course course) {
		log.info("Inside saveCourse of CourseService");
		return courseRepository.save(course);
	}

	public Course findCourseByCourseId(Long courseId) {
		log.info("Inside findCourseByCourseId of CourseService");
		return courseRepository.findCourseByCourseId(courseId);
	}

}
