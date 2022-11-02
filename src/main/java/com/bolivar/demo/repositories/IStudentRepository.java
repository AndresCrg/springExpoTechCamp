package com.bolivar.demo.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bolivar.demo.models.Student;


@Repository
@Transactional
public interface IStudentRepository extends JpaRepository<Student, Long>{
	
//	@Query("SELECT s.id, s.name, s.email, s.dob, s.age FROM Student AS s WHERE s.name=:subject")
//	List<Student> findStudentBySubject(@Param(value = "subject") String subject);
	
//	@Query("SELECT NEW com.bolivar.demo.models.Student(s.id, s.name, s.email, s.dob, s.age) FROM Student AS s WHERE s.name=:subject")
//	Student findStudentBySubject(@Param(value = "subject") String subject);
	
//	@Query("SELECT NEW com.bolivar.demo.models.Student(s.id, s.name, s.email, s.dob, s.age) FROM Student as s INNER JOIN rel_stud_subj ON s.id = fk_student INNER JOIN Subject as su ON su.id = fk_subject WHERE su.name =:subject")
//	List<Student> findStudentBySubject(@Param(value = "subject") String subject);
	
	@Query(nativeQuery=true, value = "SELECT students.id, students.name, students.email, students.dob, students.age FROM students INNER JOIN rel_stud_subj ON students.id = rel_stud_subj.fk_student INNER JOIN subjects ON subjects.id = rel_stud_subj.fk_subject WHERE subjects.name =:subject")
	List<Object[]> findStudentBySubject(@Param(value = "subject") String subject);
}
