package com.bolivar.demo.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "students", schema = "C##STUDENTS")
public class Student implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id 
	@SequenceGenerator(
			name = "student_seq",
			sequenceName = "student_seq_name",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "student_seq_name")
	private Long id;
	private String name;
	private String email;
	private LocalDate dob;
	private Integer age;
	
    @JoinTable(
            name = "rel_stud_subj",
            joinColumns = @JoinColumn(name = "fk_student", nullable = false),
            inverseJoinColumns = @JoinColumn(name="fk_subject", nullable = false)
        )
        @ManyToMany(cascade = CascadeType.ALL)
	private List<Subject> stuSubjects;
	
	public Student() {}

	public Student(String name, String email, LocalDate dob, Integer age, List<Subject> stuSubjects) {
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.age = age;
		this.stuSubjects = stuSubjects;
	}

	public Student(Long id, String name, String email, LocalDate dob, Integer age) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.age = age;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<Subject> getStuSubjects() {
		return stuSubjects;
	}

	public void setStuSubjects(List<Subject> stuSubjects) {
		this.stuSubjects = stuSubjects;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", age=" + age
				+ ", stuSubjects=" + stuSubjects + "]";
	}
}