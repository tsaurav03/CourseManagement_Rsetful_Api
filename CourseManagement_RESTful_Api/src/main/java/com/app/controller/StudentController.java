package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.StudentDTO;
import com.app.entities.CourseName;
import com.app.entities.Student;
import com.app.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/")
	public ResponseEntity<?>GetAllStudents(){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.getAllStudents());
	}
	
	@GetMapping("/course")
	public ResponseEntity<?>GetAllStudentByChosenCategory(@RequestParam CourseName course){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.getAllStudentOfSpecificCourse(course));
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?>updateStudentDetails(@PathVariable Long id, @RequestBody Student std){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.updateStudent(id, std));
	}
	
	@PostMapping("/")
	public ResponseEntity<?>addStudent(@RequestBody StudentDTO dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.addStudent(dto));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?>deleteStudentDetails(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.deleteStudentById(id));
	}

}
