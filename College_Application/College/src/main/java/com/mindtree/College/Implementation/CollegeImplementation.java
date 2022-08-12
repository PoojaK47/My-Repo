package com.mindtree.College.Implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mindtree.College.Entity.College;
import com.mindtree.College.Repository.ColgRepository;
import com.mindtree.College.Service.CollegeService;
import com.mindtree.College.VO.RequestTemplate;
import com.mindtree.College.VO.Student;

@Component
public class CollegeImplementation implements CollegeService  {
	@Autowired
	ColgRepository colgRepo;
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public College add(College college) {
		return colgRepo.save(college);
	}

	@Override
	public List<College> list() {
		return colgRepo.findAll();
	}

	@Override
	public College update(long id, String name) {
		College college = colgRepo.findById(id);
		college.setName(name);
		return colgRepo.save(college);
	}

	@Override
	public College searchById(long id) {
		if(colgRepo.findById(id)==null)
		{
			return null;
		}
		return colgRepo.findById(id);
	}

	@Override
	public List<RequestTemplate> listWithStu() {
		List<RequestTemplate> fullList = new ArrayList<RequestTemplate>();
		List<College> allCollege = this.list();
		Iterator<College> ir = allCollege.iterator();
		while(ir.hasNext())
		{
			College college = ir.next();
			ResponseEntity<Student[]> response =
					  restTemplate.getForEntity(
							  "http://STUDENT-RECORD/student/student-with-ascname/"+college.getId(),
					  Student[].class);
			Student[] students = response.getBody();
			List<Student> stus = Arrays.asList(students);
 			RequestTemplate RTm = new RequestTemplate();
			RTm.setCollege(college);
			RTm.setStudentList(stus);
			fullList.add(RTm);
		}
		return fullList;
	}

	@Override
	public RequestTemplate specificColgStudent(long college_id) {
		College college  = this.searchById(college_id);
		
		ResponseEntity<Student[]> response =
				  restTemplate.getForEntity(
						  "http://STUDENT-RECORD/student/student-with-desc-age/"+college.getId(),
				  Student[].class);
		Student[] student = response.getBody();
		List<Student> students = Arrays.asList(student);
		RequestTemplate requestTemplate = new RequestTemplate();
		
		requestTemplate.setCollege(college);
		requestTemplate.setStudentList(students);
		
		return requestTemplate;
	}

}
