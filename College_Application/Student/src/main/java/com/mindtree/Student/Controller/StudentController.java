package com.mindtree.Student.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.Student.Entity.Student;
import com.mindtree.Student.Service.StudentService;
import com.mindtree.Student.VO.ResponseTemplate;


@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService stuService;
	
	@PostMapping
	public Student add(@RequestBody Student stu)
	{
		return stuService.add(stu);
	}
	
	@GetMapping
	public List<Student> liststud(){
		return stuService.list();
	}
	
	@GetMapping("/{stuId}")
	public ResponseTemplate stuWithColg(@PathVariable long stuId)
	{
		return stuService.stuWithColg(stuId);
	}
	
	@PutMapping("/{stuId}/{collegeId}")
	public String updateCollege(@PathVariable long stuId,@PathVariable long collegeId)
	{
		Student stu = stuService.assignCollege(stuId,collegeId);
		if(stu!=null)
		{
			return stu.toString();
		}
		return "Sorry. College or Student Not Found";
	}
	
	@GetMapping("/Student-with-ascname/{college_id}")
	public List<Student> getByColgId(@PathVariable long college_id)
	{
		return stuService.getByColgId(college_id);
	}
	
	@GetMapping("/Student-with-desc-age/{college_id}")
	public List<Student> getStudentByCollegeWithDescAge(@PathVariable long college_id)
	{
		return stuService.getStudentByCollegeWithDescAge(college_id);
	}

}


