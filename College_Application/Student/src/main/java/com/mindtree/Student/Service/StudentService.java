package com.mindtree.Student.Service;

import java.util.List;

import com.mindtree.Student.Entity.Student;
import com.mindtree.Student.VO.ResponseTemplate;

public interface StudentService {
	Student add(Student stu);
	List<Student> list();
	Student searchById(long id);
	ResponseTemplate stuWithColg(long stuId);
	Student assignCollege(long stuId, long collegeId);
	List<Student> getByColgId(long college_id);
	List<Student> getStudentByCollegeWithDescAge(long college_id);

}

