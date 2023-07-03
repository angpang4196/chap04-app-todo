package org.edupoll;

import java.util.List;

import org.edupoll.model.Todo;
import org.edupoll.repository.TodoRepository;
import org.edupoll.service.AuthService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppTodoApplicationTests {

	@Autowired
	TodoRepository todoRepository;
	
	@Autowired
	AuthService authService;
	
	@Test
	void contextLoads() {
		todoRepository.deleteById("3edd5591");
		
//		todoRepository.create(new Todo("z1", "master", null, null, null));
//		todoRepository.create(new Todo("z2", "master", null, null, null));
//		todoRepository.create(new Todo("z3", "totoro", null, null, null));
//		
//		List<Todo> found = todoRepository.findByOwner("totoro");
//		System.out.println(found);
		
//		Todo found = todoRepository.findById("z1");
//		System.out.println(found);
	}

}
