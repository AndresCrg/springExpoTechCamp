package com.bolivar.demo.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "subjects")
public class Subject implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id 
	@SequenceGenerator(
			name = "subject_seq",
			sequenceName = "subject_seq_name",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "subject_seq_name")
	private Long id;
	private String name;
	private Integer credits;

	@ManyToMany(mappedBy = "stuSubjects")
	private List<Student> subStudents;

	@ManyToOne
	@JoinColumn(name = "fk_faculty", nullable = false, updatable = false)
	private Faculty faculty;

	public Subject() {}

	public Subject(String name, Integer credits, List<Student> subStudents) {
		this.name = name;
		this.credits = credits;
		this.subStudents = subStudents;
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

	public Integer getCredits() {
		return credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	public List<Student> getSubStudents() {
		return subStudents;
	}

	public void setSubStudents(List<Student> subStudents) {
		this.subStudents = subStudents;
	}
}
