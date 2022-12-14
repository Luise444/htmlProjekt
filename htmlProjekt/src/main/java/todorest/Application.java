package todorest;

import java.util.Locale.Category;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	@Autowired
	private ToDoRepository todoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	public void createTestData() {
		
		ToDo c = new ToDo();
		c.setId(1);
		c.setToDo("Best Keyboard ever");
		c.setCategory(Arbeit);
		c.setDescription("blablabla");
		c.setDeleted(false);
	
		
		todoRepository.saveToDo(c);
	}
}
