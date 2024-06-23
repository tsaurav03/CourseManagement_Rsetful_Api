package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.CustomException;
import com.app.dtos.ApiResponse;
import com.app.dtos.CourseDTO;
import com.app.entities.Course;
import com.app.repository.CourseRepository;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseRepository repo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<CourseDTO> findCourseByCourseName(String courseName) {
	    return repo.findByCourseName(courseName)
	    		.stream()
	    		.map(i->mapper.map(i, CourseDTO.class))
	    		.collect(Collectors.toList());
	}

	@Override
	public List<CourseDTO> FindAllCourses() {
	   return repo.findAll().stream().map(i->mapper.map(i, CourseDTO.class))
			   .collect(Collectors.toList());
	}

	@Override
	public CourseDTO addCourse(CourseDTO courseDTO) {
		Course course = mapper.map(courseDTO, Course.class);
		if(course.getStartDate().isAfter(course.getEndDate())) {
			throw new CustomException("Course Start date cannot be after Course End Date!!!");
		}else {
			return mapper.map(repo.save(course),CourseDTO.class);
		}
	}

	@Override
	public ApiResponse updateCourseDetails(Long id, CourseDTO courseDTO) {
	    Course course = repo.findById(id)
	    		.orElseThrow(()->new CustomException("Course with id:"+id+"Not Found"));
	    
	    if(courseDTO.getStartDate().isAfter(courseDTO.getEndDate())) {
	    	throw new CustomException("Course Start date cannot be after Course End Date!!!");
	    }
	    
	    repo.save(mapper.map(courseDTO, Course.class));
	    
	    return new ApiResponse("Course Updated Successfully");
	    
	}

	@Override
	public ApiResponse deleteCourseById(Long id) {
	 Course course = repo.findById(id).orElseThrow(()->new CustomException("Course with id"+id+"Not Found"));
	 repo.delete(course);
	 return new ApiResponse("Course Deleted Successfully");
	}

}
