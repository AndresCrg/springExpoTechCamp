package com.bolivar.demo.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bolivar.demo.models.Student;
import com.bolivar.demo.repositories.IStudentRepository;

//@Configuration
//public class StudentConfig {
//	
//	@Bean
//	CommandLineRunner commandLineRunner(IStudentRepository repository) {
//		return args-> {
//			Student std1 = new Student("Juana", "jauna@gmail.com", LocalDate.now(), 20);
//			Student std2 = new Student("Pepito", "pepito@gmail.com", LocalDate.now(), 21);
//			repository.saveAll(List.of(std1, std2));
//		};
//	}
//}
