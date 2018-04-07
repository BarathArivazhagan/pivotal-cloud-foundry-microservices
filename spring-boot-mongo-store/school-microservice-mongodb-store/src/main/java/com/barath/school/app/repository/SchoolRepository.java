package com.barath.school.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.barath.school.app.document.School;

public interface SchoolRepository extends MongoRepository<School, Long> {
	
	
	School findBySchoolId(Long schoolId);
	School findBySchoolName(String schoolName);
	
}
