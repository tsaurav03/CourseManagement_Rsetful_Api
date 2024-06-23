package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	
     List<Course> findByCourseName(String courseName);
     
     Course findByCourseUniqueConstraintKey(String courseUniqueConstraintKey);

}
