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
import org.springframework.web.bind.annotation.RestController;

import com.bolivar.demo.models.Subject;
import com.bolivar.demo.services.SubjectService;

@RestController
@RequestMapping(path = "api/subject")
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	

//	public StudentController(StudentService studentbService) {
//		this.studentbService = studentbService;
//	}
	
	@GetMapping()
	public List<Subject> getAllStudents() {
		return subjectService.getAllSubjects();
	}
	
	@PostMapping()
	public void saveStudent(@RequestBody Subject subject) {
		subjectService.saveSubject(subject);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<String> updateSubject(@PathVariable Long id, @RequestBody Subject subject) {
		JSONObject resp = new JSONObject();
	    try {
	    	Subject oldSubject = subjectService.updateSubject(id, subject);
			resp.put("status", 200);
			resp.put("msg", "Subject updated sucessfully!");
			resp.put("student", oldSubject);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>(resp.toString(), HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/{id}")
	public void deleteSubject(@PathVariable Long id) {
		JSONObject resp = new JSONObject();
		try {
			subjectService.deleteSubject(id);
			resp.put("status", 200);
			resp.put("msg", "Subject deleted sucessfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
