package com.mindtree.College;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mindtree.College.Entity.College;
import com.mindtree.College.Repository.ColgRepository;

@SpringBootTest
class CollegeApplicationTests {
	
	ColgRepository colgRepo;

	@Test
	void junitTest() {
		College colg = new College();
		colg.setId(1005);
		colg.setName("GnanaPeeta College");
		
		colgRepo.save(colg);
		assertNotNull(colgRepo.findById(1004).getId());
		
	}

}
