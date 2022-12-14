package todorest;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import todorest.articlemgmt.services.Category;

//Item Service
@Component
public class ToDoRepository {
	
	
	private List<ToDo> todos = new ArrayList<>();
	
	
	public List<ToDo> getToDo() {
		return todos;
	}

	public void saveToDo(ToDo c) {
		ToDo removeOld = null;
		for (ToDo aOld : todos) {
				if (aOld.getId() == c.getId()) {
					removeOld = aOld;
					break;
				}
			}
			if (removeOld != null)
				todos.remove(removeOld);

			todos.add(c);
	}
	
	public ToDo getToDoById(int id) {
		for (ToDo a : todos) {
			if (a.getId() == id) {
				return a;
			}
		}
		return null;
	

	}
//??  Zeile 49
	public List<ToDo> findToDoByType(Category category) {
		List<ToDo> results = new ArrayList<>();
		for (ToDo  t : todos) {
			if (t.getCategory().equals(category)) {
			results.add(t);
			}
		}

			
		return results;
	}

	
	

}