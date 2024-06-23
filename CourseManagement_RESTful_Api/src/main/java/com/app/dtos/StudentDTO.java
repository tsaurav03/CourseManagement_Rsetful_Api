package com.app.dtos;

import com.app.entities.Course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
	private String studentName;
	private String email;

	private String password;
	private Course course;
}
