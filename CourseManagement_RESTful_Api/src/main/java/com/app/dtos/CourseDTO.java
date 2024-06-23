package com.app.dtos;

import java.time.LocalDate;

import com.app.entities.Category;
import com.app.entities.CourseName;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CourseDTO {
	private CourseName courseName;
	private Category category;
	private String courseUniqueConstraintKey;
	private LocalDate startDate;
	private LocalDate endDate;
	private double fees;

	private String grade;

}
