package com.mindtree.Student.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mindtree.Student.Entity.Student;
import com.mindtree.Student.Repository.StudentRepository;
import com.mindtree.Student.Service.StudentService;
import com.mindtree.Student.VO.College;
import com.mindtree.Student.VO.ResponseTemplate;



@Component
public class StudentImpl implements StudentService {
	@Autowired
	private StudentRepository stuRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Student add(Student stu) {
		return stuRepo.save(stu);
	}

	@Override
	public List<Student> list() {
		return stuRepo.findAll();
	}

	@Override
	public Student searchById(long id) {
		return stuRepo.findById(id);
	}

	@Override
	public ResponseTemplate stuWithColg(long stuId) {
		ResponseTemplate RT = new ResponseTemplate();
		Student stu = stuRepo.findById(stuId);
		
		long college_id = stu.getcollege_id();
		College college = restTemplate.getForObject("http://COLLEGE-RECORD/college/"+college_id, College.class);
		RT.setCollege(college);
		RT.setStudent(stu);
		return RT;
	}

	@Override
	public Student assignCollege(long stuId, long collegeId) {
		Student stu = stuRepo.findById(stuId);
		College college = restTemplate.getForObject("http://COLLEGE-RECORD/college/"+collegeId, College.class);
		if(stu==null || college==null)
		{
			return null;
		}
		stu.setCollege_id(collegeId);
		stuRepo.save(stu);
		return stu;
	}

	@Override
	public List<Student> getByColgId(long college_id) {
		return stuRepo.getByColgId(college_id);
	}

	@Override
	public List<Student> getStudentByCollegeWithDescAge(long college_id) {
		return stuRepo.getStudentByCollegeWithDescAge(college_id);
	}

}

