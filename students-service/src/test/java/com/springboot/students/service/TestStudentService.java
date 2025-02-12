package com.springboot.students.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import com.springboot.students.entity.Student;
import com.springboot.students.repository.StudentRepository;
import com.springboot.students.vo.Course;
import com.springboot.students.vo.StudentVO;

@ExtendWith(MockitoExtension.class)
public class TestStudentService {

    @Mock
    private StudentRepository stuRepository;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private StudentService studentService;

    private Student student;
    private Course course;

    @BeforeEach
    public void setUp() {
        student = new Student();
        student.setRegNo(1L);
        student.setFirstName("keerthi");
        student.setCourseId(101L);

        course = new Course();
        course.setCourseId(101L);
        course.setCourseName("Computer Science");
    }

    @Test
    public void testSaveStudent() {
        when(stuRepository.save(student)).thenReturn(student);
        Student savedStudent = studentService.saveStudent(student);
        assertNotNull(savedStudent);
        assertEquals(student.getRegNo(), savedStudent.getRegNo());
    }

    /*@Test
    public void testGetStudentWithCourse() {
        when(stuRepository.findByRegNo(anyLong())).thenReturn(student);
        when(restTemplate.getForObject("http://COURSE-SERVICE/courses/" + student.getCourseId(), Course.class))
                .thenReturn(course);
        StudentVO studentVO = studentService.getStudentWithCourse(101L, "keerthi");
        assertNotNull(studentVO);
        assertNotNull(studentVO.getStudent());
        assertNotNull(studentVO.getCourse());
        assertEquals(student.getRegNo(), studentVO.getStudent().getRegNo());
        assertEquals(course.getCourseId(), studentVO.getCourse().getCourseId());
    }*/
    
    @Test
    public void testGetStudentWithCourse() {
        when(stuRepository.findByRegNoAndFirstName(anyLong(), anyString())).thenReturn(student);
        when(restTemplate.getForObject("http://COURSE-SERVICE/courses/" + student.getCourseId(), Course.class))
                .thenReturn(course);
        StudentVO studentVO = studentService.getStudentWithCourse(1L, "keerthi");
        assertNotNull(studentVO);
        assertNotNull(studentVO.getStudent());
        assertNotNull(studentVO.getCourse());
        assertEquals(student.getRegNo(), studentVO.getStudent().getRegNo());
        assertEquals(course.getCourseId(), studentVO.getCourse().getCourseId());
    }
}
