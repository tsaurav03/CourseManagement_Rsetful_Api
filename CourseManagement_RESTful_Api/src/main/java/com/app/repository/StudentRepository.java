package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.CourseName;
import com.app.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
	@Query("Select S from Student S where S.course.courseName =:name")
	List<Student> findAllByCourse(CourseName name);

}
