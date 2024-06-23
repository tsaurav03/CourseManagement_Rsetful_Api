package com.app.service;

import java.util.List;

import com.app.dtos.ApiResponse;
import com.app.dtos.CourseDTO;

public interface CourseService {
	List<CourseDTO> findCourseByCourseName(String courseName);
	List<CourseDTO>FindAllCourses();
	
	CourseDTO addCourse(CourseDTO courseDTO);
	
	ApiResponse updateCourseDetails(Long id,CourseDTO courseDTO);
	
	ApiResponse deleteCourseById(Long id);

}
