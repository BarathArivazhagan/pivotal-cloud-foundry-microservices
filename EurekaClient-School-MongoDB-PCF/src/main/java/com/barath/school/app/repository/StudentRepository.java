package com.barath.school.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.barath.school.app.model.Student;

public interface StudentRepository extends MongoRepository<Student, Long>{

	Student findByStudentId(long studentId);

	Student findByStudentName(String studentName);

}
