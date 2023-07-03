package org.edupoll.repository;

import java.util.List;

import org.edupoll.model.Todo;

public interface TodoRepository {

	public abstract void create(Todo todo);

	public abstract Todo findById(String id);

	public abstract List<Todo> findByOwner(String owner);
	
	public abstract void deleteById(String id);
	
	public abstract void update(Todo todo);

}
