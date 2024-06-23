package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.CustomException;
import com.app.dtos.ApiResponse;
import com.app.dtos.StudentDTO;
import com.app.entities.Course;
import com.app.entities.CourseName;
import com.app.entities.Student;
import com.app.repository.CourseRepository;
import com.app.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository repo;

	@Autowired
	private CourseRepository courseRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public StudentDTO addStudent(StudentDTO dto) {
		Course course = courseRepo.findByCourseUniqueConstraintKey(dto.getCourse().getCourseUniqueConstraintKey());
		System.out.println(course);
		Student student = mapper.map(dto, Student.class);
		student.setCourse(course);
		Student savedStudent = repo.save(student);
		return mapper.map(savedStudent, StudentDTO.class);

	}

	@Override
	public List<StudentDTO> getAllStudents() {
             return repo.findAll().stream()
            		 .map(i->mapper.map(i,StudentDTO.class))
            		 .collect(Collectors.toList());
	}

	@Override
	public List<Student> getAllStudentOfSpecificCourse(CourseName name) {
		return repo.findAllByCourse(name);
	}

	@Override
	public ApiResponse updateStudent(Long id, Student student) {
		String mesg="Student Updation failed";
		if(repo.existsById(id)) {
			repo.save(student);
			mesg="Student details updated successfully";
		}
		return new ApiResponse(mesg);
	}

	@Override
	public ApiResponse deleteStudentById(Long id) {
		String mesg="Student deleted Successfully";
		Student student = repo.findById(id).orElseThrow(()->new CustomException("Student not Found"));
		repo.delete(student);
		return new ApiResponse(mesg);
	}

}
