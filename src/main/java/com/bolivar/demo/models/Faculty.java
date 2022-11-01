package com.bolivar.demo.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Faculties")
public class Faculty implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id 
	@SequenceGenerator(
			name = "faculty_seq",
			sequenceName = "faculty_seq_name",
			allocationSize = 1
			) 
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "faculty_seq_name")
	private Long id;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "faculty")
	private List<Subject> subjects;
	
	public Faculty() {}
	
	public Faculty(String name, ArrayList<Subject> subjects) {
		this.name = name;
		this.subjects = subjects;
	}

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

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(ArrayList<Subject> subjects) {
		this.subjects = subjects;
	}
}