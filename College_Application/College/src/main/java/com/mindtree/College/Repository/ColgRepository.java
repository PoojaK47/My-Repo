package com.mindtree.College.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.mindtree.College.Entity.College;


@Repository
public interface ColgRepository  extends JpaRepository<College, Long>{
	
	College findById(long id);
	
	//@Query(value="SELECT s.* FROM student s WHERE s.colg_id=:id ", nativeQuery = true)
	//List<Student> stuByColg(@Param("id") long id);


}


