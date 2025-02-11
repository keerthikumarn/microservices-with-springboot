package com.springboot.students.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springboot.students.entity.Student;
import com.springboot.students.repository.StudentRepository;
import com.springboot.students.vo.Course;
import com.springboot.students.vo.StudentVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentService {

	@Autowired
	private StudentRepository stuRepository;

	@Autowired
	private RestTemplate restTemplate;

	public Student saveStudent(Student student) {
		log.info("Inside saveStudent of StudentService");
		return stuRepository.save(student);
	}

	/*public StudentVO getStudentWithCourse(Long userId) {
		log.info("Inside StudentService#getStudentWithCourse()");
		StudentVO stuVO = new StudentVO();
		Student student = stuRepository.findByRegNo(userId);
		Course course = restTemplate.getForObject("http://COURSE-SERVICE/courses/" + student.getCourseId(),
				Course.class);

		stuVO.setCourse(course);
		stuVO.setStudent(student);
		
		return stuVO;
	}*/
	
	public StudentVO getStudentWithCourse(Long userId, String firstName) {
        Student student = stuRepository.findByRegNoAndFirstName(userId, firstName);
        Course course = restTemplate.getForObject("http://COURSE-SERVICE/courses/" + student.getCourseId(), Course.class);
        StudentVO stuVO = new StudentVO();
        stuVO.setCourse(course);
        stuVO.setStudent(student);
        return stuVO;
    }

}
