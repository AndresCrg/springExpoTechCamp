package com.bolivar.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolivar.demo.services.SubjectService;

@RestController
@RequestMapping(path = "api/subject")
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
}
