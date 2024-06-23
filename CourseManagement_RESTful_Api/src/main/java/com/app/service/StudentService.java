package com.app.service;

import java.util.List;

import com.app.dtos.ApiResponse;
import com.app.dtos.StudentDTO;
import com.app.entities.CourseName;
import com.app.entities.Student;

public interface StudentService {
	
	StudentDTO addStudent(StudentDTO dto) ;
	List<StudentDTO> getAllStudents();
	
	List<Student>getAllStudentOfSpecificCourse(CourseName name);
	
	ApiResponse updateStudent(Long id,Student student);
	
	ApiResponse deleteStudentById(Long id);
	
	
}
