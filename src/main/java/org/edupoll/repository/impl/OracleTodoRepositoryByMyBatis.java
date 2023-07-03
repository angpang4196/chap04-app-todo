package org.edupoll.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.edupoll.model.Todo;
import org.edupoll.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class OracleTodoRepositoryByMyBatis implements TodoRepository {

	@Autowired
	SqlSession sqlSession;

	@Override
	public void create(Todo todo) {
		sqlSession.insert("todos.create", todo);
	}

	@Override
	public Todo findById(String id) {
		return sqlSession.selectOne("todos.findById", id);
	}

	@Override
	public List<Todo> findByOwner(String owner) {
		List<Todo> list = sqlSession.selectList("todos.findByOwner", owner);
		return list;
	}

	@Override
	public void deleteById(String id) {
		sqlSession.delete("todos.deleteById", id);
	}

	@Override
	public void update(Todo todo) {
		sqlSession.update("todos.update", todo);
	}

}
