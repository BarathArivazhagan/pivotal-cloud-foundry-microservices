package com.barath.school.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barath.school.app.model.School;
import com.barath.school.app.repository.SchoolRepository;


@Service
public class SchoolService {
	

	private SchoolRepository schoolRep; 
	
	
	@Autowired
	public SchoolService(SchoolRepository schoolRep){
		this.schoolRep=schoolRep;
	}
	
	public void addSchool(School school){
		schoolRep.save(school);
	}
	
	public School getSchool(long schoolId){
		
		
		School school=schoolRep.findBySchoolId(schoolId);
		
		
		return school;
	}
	
	public School getSchool(School school){
		School schoolFound=null;
		if(school !=null){
			schoolFound=this.getSchool(school.getSchoolId());
		}
		
		
		return schoolFound;
	}

	public void updateSchool(School school){
		if(isSchoolExists(school)){
			School schoolFound=this.getSchool(school);
			if(schoolFound !=null){
				//schoolRep.
			}
			
		}
	}
	public void deleteSchool(long schoolId){
		if(isSchoolExists(schoolId)){
			schoolRep.delete(schoolId) ;
		}
	}
	public void deleteSchool(School school){
		if(isSchoolExists(school)){
			schoolRep.delete(school) ;
		}
	}
	
	public boolean isSchoolExists(long schoolId){
		School schoolFound= schoolRep.findBySchoolId(schoolId);
		return schoolFound !=null ?  true:   false;
	}
	
	public boolean isSchoolExists(School school){
		if(school != null){
			School schoolFound= schoolRep.findBySchoolId(school.getSchoolId());
			return schoolFound !=null ?  true:   false;
		}
		return false;
	}
	
	


	public School getSchool(String schoolName) {
		
		return schoolRep.findBySchoolName(schoolName);
	}
	
	

	public List<School> getSchools() {
		
		return schoolRep.findAll();
	}

	public boolean isSchoolExists(String schoolName) {
		School school= schoolRep.findBySchoolName(schoolName);
		if(school !=null){
			return true;
		}
		return false;
	}
	
	public List<String> getListOfSchoolNames(){
		
		return getSchools().stream().map(School::getSchoolName).collect(Collectors.toList());
		
	}

	


}
