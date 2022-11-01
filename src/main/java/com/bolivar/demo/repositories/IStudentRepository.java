package com.bolivar.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bolivar.demo.models.Student;


@Repository
public interface IStudentRepository extends JpaRepository<Student, Long>{

}
