package com.bolivar.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolivar.demo.models.Student;
import com.bolivar.demo.repositories.IStudentRepository;

@Service
public class StudentService {

	@Autowired
	private IStudentRepository iStudentRepository;

	//	public StudentService(IStudentRepository iStudentRepository) {
	//		this.iStudentRepository = iStudentRepository;
	//	}

	public List<Student> getAllStudents() {
		return iStudentRepository.findAll();
	}

	public Student saveStudent(Student student) {
		return iStudentRepository.save(student);
	}

	public Student updateStudent(Long id, Student student) {
		Student oldStudent = iStudentRepository.findById(id).orElseThrow();
		oldStudent.setName(student.getName());
		oldStudent.setEmail(student.getEmail());
		oldStudent.setDob(student.getDob());
		oldStudent.setAge(student.getAge());
		
		return iStudentRepository.save(oldStudent);
		 
	}

	public void deleteStudent(Long id) {
		Student student = iStudentRepository.findById(id).orElseThrow();
		iStudentRepository.delete(student);
	}
}