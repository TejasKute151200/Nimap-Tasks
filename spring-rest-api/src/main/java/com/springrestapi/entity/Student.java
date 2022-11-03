package com.springrestapi.entity;

import javax.persistence.*;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name="student")
@Where(clause = "is_active=true")
@SQLDelete(sql = "UPDATE student SET is_active=false WHERE id=?")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="student_name")
	private String name;
	
	@Column(name = "is_active")
	private Boolean isActive = true;

	public Student(long id, String name, Boolean isActive) {
		super();
		this.id = id;
		this.name = name;
		this.isActive = isActive;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", isActive=" + isActive + "]";
	}
}
