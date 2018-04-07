package com.barath.school.app.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barath.school.app.document.School;
import com.barath.school.app.service.SchoolService;

@RestController
public class SchoolController {
	
	private static final Logger logger=LoggerFactory.getLogger(SchoolController.class);
	
	
	private SchoolService schoolService;

	
	public SchoolController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}


	@RequestMapping(value="/addSchool",method=RequestMethod.POST)
	public String addSchool(@RequestBody School  school){
		if(school !=null){
			schoolService.addSchool(school);
			return "School is added successfully";
		}
		return "School is not  added successfully. Check the logs for error ";
	}
	
	
	@RequestMapping(value="/getSchool",method=RequestMethod.GET)
	public School getSchool(@RequestParam("id") Long schoolId){
		System.out.println("school Id "+schoolId);
		return schoolService.getSchool(schoolId);
	}
	
	@RequestMapping(value="/getSchoolByName",method=RequestMethod.GET)
	public School getSchool(@RequestParam("name") String schoolName){
		System.out.println("school Id "+schoolName);
		return schoolService.getSchool(schoolName);
	}
	
	@RequestMapping(value="/updateSchool",method=RequestMethod.POST)
	public String updateSchool(@RequestBody School school){
		schoolService.updateSchool(school);
		return "School is updated";
	}
	
	@RequestMapping(value="/getSchools",method=RequestMethod.GET)
	public List<School> getAllSchools(){
		return schoolService.getSchools();
	}
	
	@RequestMapping(value="/getSchoolNames",method=RequestMethod.GET)
	public List<String> getAllSchoolNames(){
		List<String> schoolNames=schoolService.getListOfSchoolNames();
		schoolNames.stream().forEach(logger::info);
		return schoolNames;
	}
	
	
	@ExceptionHandler(Exception.class)
	public String handleeError(Exception ex){
		return ex.getMessage();
	}
	

}
