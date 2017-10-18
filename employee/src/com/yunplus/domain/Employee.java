package com.yunplus.domain;

import java.io.Serializable;

public class Employee implements Serializable {
	private int id;
	private String name;
    private int salary;
    private int job;
	public Employee() {
		super();
	}
	public Employee(int id, String name, int salary, int job) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.job = job;
	}

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getSalary() {
		return salary;
	}
	public int getJob() {
		return job;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public void setJob(int job) {
		this.job = job;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", job=" + job + "]";
	}
}
