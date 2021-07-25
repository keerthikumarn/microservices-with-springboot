package com.springboot.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.courses.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

	Course findCourseByCourseId(Long courseId);
}
