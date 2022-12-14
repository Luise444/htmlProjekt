package todorest.articlemgmt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import todorest.ToDo;
import todorest.ToDoRepository;


@RestController
public class ToDoListService {

	@Autowired
	private ToDoRepository todoRepository;

	
	@GetMapping
	(path = "/api/ToDos", produces = "application/json")
	public List<ToDo> getToDo(
			@RequestParam(required = false) String ToDo,
			@RequestParam(required = false) String describtion,
			@RequestParam String catag)
	{
		// ToDo use filter
	return 	todoRepository.getToDo();
	}
		
	
}
