package todorest.articlemgmt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import todorest.ToDo;
import todorest.ToDoRepository;

@RestController


public class ToDoListCrudService {

	@Autowired
	private ToDoRepository todoRepository;

	@GetMapping(path = "/api/ToDo/{id}", produces = "application/json")
	public ToDo getToDo(@PathVariable int id) {
		return todoRepository.getToDoById(id);
	}
	@GetMapping(path = "api/ToDo/{category}", produces = "application/json")
	public List<ToDo>findToDoByType(@PathVariable Category category) {
		return todoRepository.findToDoByType(category);
		
	}

	@DeleteMapping(path = "/api/ToDo/{id}", produces = "application/json")
	public boolean deleteToDo(@PathVariable int id) {
		ToDo a = todoRepository.getToDoById(id);
		if (a == null)
			return false;
		a.setDeleted(true);
		todoRepository.saveToDo(a);
		return true;
	}

	@PutMapping(path = "/api/ToDo/{id}", produces = "application/json")
	public boolean updateToDo(@PathVariable int id, @RequestBody ToDo todo) {
		ToDo a = todoRepository.getToDoById(id);
		if (a == null)
			return false;

		a.setToDo(todo.getToDo());
		a.setCategory(todo.getCategory());
		a.setDescription(todo.getDescription());

		todoRepository.saveToDo(a);
		return true;
	}

	@PostMapping(path = "/api/ToDo/", produces = "application/json")
	public ToDo createToDo(@RequestBody ToDo todo) {
		ToDo a = new ToDo();

		a.setId(123); // wir vergeben immer die gleiche ID, nur ein Beispiel :-)
		a.setToDo(todo.getToDo());
		a.setCategory(todo.getCategory());
		a.setDescription(todo.getDescription());
		a.setDeleted(false);

		todoRepository.saveToDo(a);
		
		return a;
	}

}
