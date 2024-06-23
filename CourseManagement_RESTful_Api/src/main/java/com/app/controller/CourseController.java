package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.CourseDTO;
import com.app.service.CourseService;
@RestController
@RequestMapping("/courses")
public class CourseController {
	
	@Autowired
	private CourseService service;
	
	@PostMapping("/")
	public ResponseEntity<?> addCourse(@RequestBody CourseDTO dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.addCourse(dto));
	}

}
