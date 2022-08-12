package com.mindtree.Student.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mindtree.Student.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	Student findById(long rollNo);

	@Query(value="SELECT * FROM student WHERE college_id=:college_id ORDER BY name ASC", nativeQuery = true)
	List<Student> getByColgId(@Param("college_id") long college_id);
	
	@Query(value="SELECT * FROM student WHERE college_id=:college_id ORDER BY age DESC", nativeQuery = true)
	List<Student> getStudentByCollegeWithDescAge(@Param("college_id") long college_id);


}






