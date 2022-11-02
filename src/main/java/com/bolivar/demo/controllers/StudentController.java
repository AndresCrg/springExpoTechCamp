package com.bolivar.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bolivar.demo.models.Student;
import com.bolivar.demo.services.StudentService;

@RestController
@RequestMapping(path = "api/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	

//	public StudentController(StudentService studentbService) {
//		this.studentbService = studentbService;
//	}
	
	@GetMapping()
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}
	
	@GetMapping(path = "/{subject}")
	public List<Object[]> findStudentBySubject(@PathVariable String subject){
		System.out.println("La variable es: " + subject);
		return studentService.findStudentBySubject(subject);
	}
	
//	@GetMapping(path = "/{subject}")
//	public Student findStudentBySubject(@PathVariable String subject){
//		System.out.println("La variable es: " + subject);
//		return studentService.findStudentBySubject(subject);
//	}
	
	@PostMapping()
	public ResponseEntity<String> saveStudent(@RequestBody Student student) {

		JSONObject resp = new JSONObject();
	    try { 
	    	Student newStudent = studentService.saveStudent(student);
			resp.put("status", 200);
			resp.put("msg", "Student created sucessfully!");
			resp.put("student", newStudent);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>(resp.toString(), HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody Student student) {
		JSONObject resp = new JSONObject();
	    try {
	    	Student oldStudent = studentService.updateStudent(id, student);
			resp.put("status", 200);
			resp.put("msg", "Student updated sucessfully!");
			resp.put("student", oldStudent);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>(resp.toString(), HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/{id}")
	public void deleteStudent(@PathVariable Long id) {
		JSONObject resp = new JSONObject();
		try {
			studentService.deleteStudent(id);
			resp.put("status", 200);
			resp.put("msg", "Student deleted sucessfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
