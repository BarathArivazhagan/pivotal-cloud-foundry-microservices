package com.barath.school.app.service;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.barath.school.app.document.School;
import com.barath.school.app.repository.SchoolRepository;


@Service
public class SchoolService {
	
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	private final SchoolRepository schoolRepository;
	
	
	public SchoolService(SchoolRepository schoolRepository){
		this.schoolRepository=schoolRepository;
	}
	
	public School addSchool(School school){
		
		if (logger.isInfoEnabled()) logger.info(" saving school with details {} ",school);
		return schoolRepository.save(school);
	}
	
	public School getSchool(Long schoolId){

		return schoolRepository.findBySchoolId(schoolId);
		
	}
	
	public School getSchool(School school) throws Exception{

		Optional<School> schoolOptional=Optional.ofNullable(school);
		if (logger.isInfoEnabled()) logger.info(" getting school with details {} ",school);
		return schoolOptional.isPresent() ? getSchool(school.getSchoolId()) : schoolOptional.orElse(new School());

	}

	public School updateSchool(School school){

		return addSchool(school);
	}

	public void deleteSchool(Long schoolId){

		if (logger.isInfoEnabled()) logger.info(" deleting school with details {} ",schoolId);
		schoolRepository.delete(schoolId) ;

	}
	public void deleteSchool(School school){

		schoolRepository.delete(school) ;

	}
	

	public School getSchool(String schoolName) {
		
		return schoolRepository.findBySchoolName(schoolName);
	}


	public List<School> getSchools() {
		
		return schoolRepository.findAll();
	}

	public boolean isSchoolExists(String schoolName) {

		return Optional.ofNullable(getSchool(schoolName)).isPresent();
	}

	public boolean isSchoolExists(Long schoolId){

		return Optional.ofNullable(getSchool(schoolId)).isPresent();

	}

	public boolean isSchoolExists(School school) throws Exception{

		return Optional.ofNullable(getSchool(school)).isPresent();
	}


	public List<String> getListOfSchoolNames(){
		
		return getSchools().stream().map(School::getSchoolName).collect(Collectors.toList());
		
	}
	
	/**
	 * This method to populate some data for testing.
	 * 
	 */
	@PostConstruct
	public void init(){
		
	    if(logger.isInfoEnabled()) logger.info("populating values to the database");
		Arrays.asList(new School(1L,"ST.BEDES"),
				new School(2L,"ST.BEDES1"),
				new School(3L,"ST.BEDES2"),
				new School(4L,"ST.BEDES3"),
				new School(5L,"ST.BEDES4"),
				new School(6L,"ST.BEDES5"),
				new School(7L,"ST.BEDES6")).forEach(this::addSchool);
		
		
		
	}

	


}
