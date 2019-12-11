package com.slokam.rest.entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student{
	
	
  /*	public Student(Integer id, String name, String qual, Long phone, Integer marks) {
		super();
		this.id = id;
		this.name = name;
		this.qual = qual;
		this.phone = phone;
		this.marks = marks;
	}*/
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String qual;
	private Long phone;
	private Integer marks;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQual() {
		return qual;
	}
	public void setQual(String qual) {
		this.qual = qual;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public Integer getMarks() {
		return marks;
	}
	public void setMarks(Integer marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", qual=" + qual + ", phone=" + phone + ", marks=" + marks
				+ "]";
	}
	
	
	
	

}
