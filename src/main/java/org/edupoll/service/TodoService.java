package org.edupoll.service;

import java.util.List;
import java.util.UUID;

import org.edupoll.model.Todo;
import org.edupoll.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

	@Autowired
	TodoRepository todoRepository;

	public boolean updateTodo(Todo todo, String commander) {
		Todo found = todoRepository.findById(todo.getId());
		if(found.getOwner().equals(commander)) {
			todoRepository.update(todo);
			return true;
		}
		return true;
	}

	public boolean removeTodo(String todoId, String commander) {
		Todo todo = todoRepository.findById(todoId);
		if (todo == null) {
			return false;
		}
		if (todo.getOwner().equals(commander)) {
			todoRepository.deleteById(todoId);
			return true;
		} else {
			return false;
		}
	}

	public boolean addNewTodo(Todo todo, String logonId) {
		String id = UUID.randomUUID().toString().split("-")[0];
		Todo found = todoRepository.findById(id);

		if (found == null) {
			todo.setId(id);
			todo.setOwner(logonId);

			todoRepository.create(todo);
			return true;
		} else {
			return false;
		}
	}

	public List<Todo> getTodos(String logonId) {
		List<Todo> todos = todoRepository.findByOwner(logonId);
		for(Todo todo : todos) {
			if(todo.getTargetDate().getTime() - System.currentTimeMillis() < 1000l * 60 * 60 * 24 * 10) {
				todo.setWarning(true);
			}
		}
		return todos;
	}

	public Todo findByTodoId(String todoId) {
		Todo todo = todoRepository.findById(todoId);
		return todo;
	}

}
