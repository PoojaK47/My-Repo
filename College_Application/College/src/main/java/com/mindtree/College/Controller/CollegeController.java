package com.mindtree.College.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.College.Entity.College;
import com.mindtree.College.Service.CollegeService;
import com.mindtree.College.VO.RequestTemplate;



@RestController
@RequestMapping("/college")
public class CollegeController {
	@Autowired
	CollegeService colgService;
	
	@PostMapping
	public College add(@RequestBody College college)
	{
		return colgService.add(college);
	}
	
	@GetMapping
	public List<College> list()
	{
		return colgService.list();
	}
	
	@GetMapping("/{id}")
	public College searchById(@PathVariable long id)
	{
		return colgService.searchById(id);
	}
	
	@GetMapping("/all-college-student")
	public List<RequestTemplate> listWithStu()
	{
		return colgService.listWithStu();
	}
	
	@GetMapping("/college-with-student/{college_id}")
	public RequestTemplate specificColgStu(@PathVariable long college_id)
	{
		return colgService.specificColgStudent(college_id);
	}
	

}

