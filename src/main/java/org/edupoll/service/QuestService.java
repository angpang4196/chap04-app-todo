package org.edupoll.service;

import java.util.List;
import java.util.UUID;

import org.edupoll.model.Quest;
import org.edupoll.model.Todo;
import org.edupoll.repository.QuestRepository;
import org.edupoll.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuestService {

	@Autowired
	TodoRepository todoRepository;
	@Autowired
	QuestRepository questRepository;

	public List<Quest> getQuests() {
		List<Quest> quests = questRepository.findQuest();

		return quests;
	}

	@Transactional
	public boolean update(int id, String logonId) {
		List<Todo> todos = todoRepository.findByOwner(logonId);
		Quest quest = questRepository.findById(id);

		if (todos.stream().filter(t -> {
			return t.getDescription().equals(quest.getDescription());
		}).toList().isEmpty()) {
			Todo todo = new Todo();
			todo.setId(UUID.randomUUID().toString().split("-")[0]);
			todo.setDescription(quest.getDescription());
			todo.setTargetDate(quest.getEndDate());
			todo.setOwner(logonId);

			todoRepository.create(todo);
			
			quest.setJoinCnt(quest.getJoinCnt() + 1);
			questRepository.update(quest);
			return true;
		} else {
			return false;
		}
	}

}
