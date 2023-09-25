package com.gl.ioc.model;

public class Student {

	private int age;
	private String name;
	private String email;

	public Student() {
		System.out.println("Student default constructor called...");
	}

	public Student(int age) {
		super();
		this.age = age;
	}

	public Student(int age, String name) {
		super();
		this.age = age;
		this.name = name;
		System.out.println("Student parametrized constructor called...");
	}

	public Student(int age, String name, String email) {
		super();
		this.age = age;
		this.name = name;
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [age=" + age + ", name=" + name + ", email=" + email + "]";
	}

	public void show() {
		System.out.println("This is demo method");
	}

}
