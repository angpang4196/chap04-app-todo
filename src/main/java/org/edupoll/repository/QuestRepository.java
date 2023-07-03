package org.edupoll.repository;

import java.util.List;

import org.edupoll.model.Quest;

public interface QuestRepository {
	
	public abstract List<Quest> findQuest();
	
	public abstract Quest findById(int id);
	
	public abstract int update(Quest quest);

}
