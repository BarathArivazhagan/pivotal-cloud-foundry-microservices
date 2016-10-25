package com.barath.school.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.barath.school.app.model.School;

public interface SchoolRepository extends MongoRepository<School, Long> {
	
	
	public School findBySchoolId(long schoolId);
	public School findBySchoolName(String schoolName);
	
}
