package com.mindtree.College.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.College.Entity.College;
import com.mindtree.College.VO.RequestTemplate;

@Service
public interface CollegeService {
	College add(College college);
	List<College> list();
	College update(long id,String name);
	College searchById(long id);
	List<RequestTemplate> listWithStu();
	RequestTemplate specificColgStudent(long college_id);


}
