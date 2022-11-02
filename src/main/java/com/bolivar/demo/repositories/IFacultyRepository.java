package com.bolivar.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bolivar.demo.models.Faculty;

@Repository
public interface IFacultyRepository extends JpaRepository <Faculty, Long>{

}
