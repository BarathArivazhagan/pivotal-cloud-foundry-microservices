package com.barath.school.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barath.school.app.model.Student;
import com.barath.school.app.repository.StudentRepository;

@Service
public class StudentService {	
		
		private Logger logger=LoggerFactory.getLogger(StudentService.class);
		private StudentRepository studentRep=null; 
		private SchoolService schoolService=null;
		
		
		@Autowired
		public StudentService(StudentRepository studentRep,SchoolService schoolService){
			this.studentRep=studentRep;
			this.schoolService=schoolService;
		}
		
		public void addStudent(Student student){
			if(!isStudentExists(student.getStudentId())){
				logger.info("Student doesnt exist ==> adding the student");
				if(student.getSchool() !=null && !schoolService.isSchoolExists(student.getSchool())){
					logger.info("SCHOOL DOESNT EXIST ADDING TO THE SCHOOL DOCUMENT");
					schoolService.addSchool(student.getSchool());
				}
				studentRep.save(student);
			}else{
				logger.error("Student Already exists");
			}
			
		}
		
		public Student getStudent(long studentId){
						
			Student student=studentRep.findByStudentId(studentId);		
			return student;
		}
		
		public Student getStudent(Student student){
			Student studentFound=null;
			if(student !=null){
				studentFound=this.getStudent(student.getStudentId());
			}
			
			
			return studentFound;
		}

		public void updateStudent(Student student){
			if(isStudentExists(student)){
				Student studentFound=this.getStudent(student);
				if(studentFound !=null){
					studentFound.setSchool(student.getSchool());
					studentFound.setStudentName(student.getStudentName());
				}
				
			}
		}
		public void deleteStudent(long studentId){
			if(isStudentExists(studentId)){
				studentRep.delete(studentId) ;
			}
		}
		public void deleteStudent(Student student){
			if(isStudentExists(student)){
				studentRep.delete(student) ;
			}
		}
		
		public boolean isStudentExists(long studentId){
			Student studentFound= studentRep.findByStudentId(studentId);
			return studentFound !=null ?  true:   false;
		}
		
		public boolean isStudentExists(Student student){
			if(student != null){
				Student studentFound= studentRep.findByStudentId(student.getStudentId());
				return studentFound !=null ?  true:   false;
			}
			return false;
		}
		
		


		public Student getStudent(String studentName) {
			
			return studentRep.findByStudentName(studentName);
		}
		
		

		public List<Student> getStudents() {
			
			return studentRep.findAll();
		}

		


	


}
