package com.barath.school.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.barath.school.app.document.Student;

public interface StudentRepository extends MongoRepository<Student, Long>{

	Student findByStudentId(Long studentId);
	Student findByStudentName(String studentName);

}
