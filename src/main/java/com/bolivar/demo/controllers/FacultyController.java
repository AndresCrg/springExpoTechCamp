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

import com.bolivar.demo.models.Faculty;
import com.bolivar.demo.services.FacultyService;


@RestController
@RequestMapping(path = "api/faculty")
public class FacultyController {
	
	@Autowired
	private FacultyService facultyService;
	
	@GetMapping()
	public List<Faculty> getAllFaculties() {
		return facultyService.getAllFaculties();
	}
	
	@PostMapping()
	public void saveFaculty(@RequestBody Faculty faculty) {
		facultyService.saveFaculty(faculty);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<String> updateFaculty(@PathVariable Long id, @RequestBody Faculty faculty) {
		JSONObject resp = new JSONObject();
	    try {
	    	Faculty oldFaculty = facultyService.updateFaculty(id, faculty);
			resp.put("status", 200);
			resp.put("msg", "Faculty updated sucessfully!");
			resp.put("faculty", oldFaculty);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>(resp.toString(), HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/{id}")
	public void deleteFaculty(@PathVariable Long id) {
		JSONObject resp = new JSONObject();
		try {
			facultyService.deleteFaculty(id);
			resp.put("status", 200);
			resp.put("msg", "Faculty deleted sucessfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
