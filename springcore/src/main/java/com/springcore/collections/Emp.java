package com.springcore.collections;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Emp {
	
	private String name;
	private List<Integer> id; 
	private Set<String> phones;
	private Map<String, String> courses;
	
	public Emp(String name, List<Integer> id, Set<String> phones, Map<String, String> courses) {
		super();
		this.name = name;
		this.id = id;
		this.phones = phones;
		this.courses = courses;
	}
	
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getId() {
		return id;
	}

	public void setId(List<Integer> id) {
		this.id = id;
	}

	public Set<String> getPhones() {
		return phones;
	}

	public void setPhones(Set<String> phones) {
		this.phones = phones;
	}

	public Map<String, String> getCourses() {
		return courses;
	}

	public void setCourses(Map<String, String> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Emp [name=" + name + ", id=" + id + ", phones=" + phones + ", courses=" + courses + "]";
	}
	
}
