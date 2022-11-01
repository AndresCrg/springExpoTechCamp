package com.bolivar.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolivar.demo.repositories.ISubjectRepository;

@Service
public class SubjectService {
	
	@Autowired
	private ISubjectRepository repository;
}
