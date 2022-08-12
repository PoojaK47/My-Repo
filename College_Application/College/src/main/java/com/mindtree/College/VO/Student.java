package com.mindtree.College.VO;

public class Student {
	private long id;
	private String name;
	private String gender;
	private int age;
	private String stream;
	private long college_id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public long getCollege_id() {
		return college_id;
	}
	public void setCollege_id(long college_id) {
		this.college_id = college_id;
	}

	public Student(String name, String gender, int age,String stream, long college_id) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.stream=stream;
		this.college_id = college_id;
	}
	public Student() {
		super();
	}

}
