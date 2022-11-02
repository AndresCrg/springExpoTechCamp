package com.bolivar.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolivar.demo.models.Subject;
import com.bolivar.demo.repositories.ISubjectRepository;

@Service
public class SubjectService {
	
	@Autowired
	private ISubjectRepository iSubjectRepository;
	

	//	public SubjectService(ISubjectRepository iSubjectRepository) {
	//		this.iSubjectRepository = iSubjectRepository;
	//	}

	public List<Subject> getAllSubjects() {
		return iSubjectRepository.findAll();
	}

	public Subject saveSubject(Subject subject) {
		return iSubjectRepository.save(subject);
	}

	public Subject updateSubject(Long id, Subject subject) {
		Subject oldSubject = iSubjectRepository.findById(id).orElseThrow();
		oldSubject.setName(subject.getName());
		oldSubject.setCredits(subject.getCredits());
	
		
		return iSubjectRepository.save(oldSubject);
		 
	}

	public void deleteSubject(Long id) {
		Subject subject = iSubjectRepository.findById(id).orElseThrow();
		iSubjectRepository.delete(subject);
	}
}
