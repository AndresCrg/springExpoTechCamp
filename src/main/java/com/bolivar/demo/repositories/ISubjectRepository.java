package com.bolivar.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bolivar.demo.models.Subject;

@Repository
public interface ISubjectRepository extends JpaRepository<Subject, Long>{

}
