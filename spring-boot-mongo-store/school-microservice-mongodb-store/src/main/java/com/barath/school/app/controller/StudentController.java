package com.barath.school.app.controller;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barath.school.app.document.School;
import com.barath.school.app.document.Student;
import com.barath.school.app.service.SchoolService;
import com.barath.school.app.service.StudentService;

@RestController
public class StudentController {
	
	private static final Logger logger=LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private SchoolService schoolService;
	
	@RequestMapping(value="/addStudent",method=RequestMethod.POST)
	public String addStudent(@RequestBody Map<String,Object> requestParams){
		if(requestParams !=null && !requestParams.isEmpty()){
			School school=null;
			logger.info("Request params "+requestParams);
			long studentId=((Integer) requestParams.get("studentId")).longValue();
			String studentName=(String)requestParams.get("studentName");
			String schoolName=(String)requestParams.get("schoolName");
			if(schoolService.isSchoolExists(schoolName)){
				school=schoolService.getSchool(schoolName);
			}else{
				school=new School(new Random().nextLong(), schoolName);
				schoolService.addSchool(school);
			}
			Student student=new Student(studentId, studentName, school);
			studentService.addStudent(student);
			return "Student is added successfully";
		}
		return "Student is not  added successfully. Check the logs for error ";
	}
	
	
	@RequestMapping(value="/getStudent",method=RequestMethod.GET)
	public Student getStudent(@RequestParam("id") Long studentId){
		System.out.println("student Id "+studentId);
		return studentService.getStudent(studentId);
	}
	
	@RequestMapping(value="/getStudentByName",method=RequestMethod.GET)
	public Student getStudent(@RequestParam("name") String studentName){
		System.out.println("student Id "+studentName);
		return studentService.getStudent(studentName);
	}
	
	@RequestMapping(value="/updateStudent",method=RequestMethod.POST)
	public String updateStudent(@RequestBody Student student){
		studentService.updateStudent(student);
		return "Student is updated";
	}
	
	@RequestMapping(value="/getStudents",method=RequestMethod.GET)
	public List<Student> getAllStudents(){
		return studentService.getStudents();
	}
	
	
	@ExceptionHandler(Exception.class)
	public String handleeError(Exception ex){
		return ex.getMessage();
	}
	

}
