package com.barath.school.app.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection="student")
public class Student {
	
	
	@Id
	@JsonIgnore
	private String id;
	
	@Indexed
	@Field
	private Long studentId;
	
	
	@Field
	private String studentName;
	
	@DBRef
	@Field
	private School school;

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((school == null) ? 0 : school.hashCode());
		result = prime * result + (int) (studentId ^ (studentId >>> 32));
		result = prime * result + ((studentName == null) ? 0 : studentName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (school == null) {
			if (other.school != null)
				return false;
		} else if (!school.equals(other.school))
			return false;
		if (studentId != other.studentId)
			return false;
		if (studentName == null) {
			if (other.studentName != null)
				return false;
		} else if (!studentName.equals(other.studentName))
			return false;
		return true;
	}

	public Student() {
		super();
		
	}

	public Student(Long studentId,String studentName, School school) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.school = school;
	}

	public Student(String studentName, School school) {
		super();
		this.studentName = studentName;
		this.school = school;
	}
	
	
	
	

}
