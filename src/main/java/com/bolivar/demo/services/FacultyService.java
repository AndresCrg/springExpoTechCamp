package com.bolivar.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolivar.demo.models.Faculty;
import com.bolivar.demo.models.Student;
import com.bolivar.demo.repositories.IFacultyRepository;

@Service
public class FacultyService {
	
	@Autowired
	private IFacultyRepository iFacultyRepository;
	
	public List<Faculty> getAllFaculties() {
		return iFacultyRepository.findAll();
	}
	
	public Faculty saveFaculty(Faculty faculty) {
		return iFacultyRepository.save(faculty);
	}
	
	public Faculty updateFaculty(Long id, Faculty faculty) {
		Faculty oldFaculty = iFacultyRepository.findById(id).orElseThrow();
		oldFaculty.setName(faculty.getName());
		return iFacultyRepository.save(oldFaculty);
	}
	
	public void deleteFaculty(Long id) {
		Faculty faculty = iFacultyRepository.findById(id).orElseThrow();
		iFacultyRepository.delete(faculty);
	}
}

