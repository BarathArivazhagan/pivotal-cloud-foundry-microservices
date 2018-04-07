package com.barath.school.app.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection="school")
public class School {
	
	@Id
	@JsonIgnore
	private String id;
	
	@Indexed
	@Field
	private Long schoolId;
	
	@Field
	private String schoolName;
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	
	@PersistenceConstructor
	public School(Long schoolId, String schoolName) {
		super();
		this.schoolId = schoolId;
		this.schoolName = schoolName;
	}

	public School() {
		super();
		
	}

	@Override
	public String toString() {
		return "School [schoolId=" + schoolId + ", schoolName=" + schoolName + "]";
	}
	
	

}
