package com.springboot.students.vo;

import com.springboot.students.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentVO {
	
	private Student student;
	private Course course;

}
