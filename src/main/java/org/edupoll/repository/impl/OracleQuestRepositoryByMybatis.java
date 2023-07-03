package org.edupoll.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.edupoll.model.Quest;
import org.edupoll.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OracleQuestRepositoryByMybatis implements QuestRepository {

	@Autowired
	SqlSession sqlSession;

	@Override
	public List<Quest> findQuest() {
		return sqlSession.selectList("quests.findQuest");
	}

	@Override
	public Quest findById(int id) {
		return sqlSession.selectOne("quests.findById", id);
	}

	@Override
	public int update(Quest quest) {
		return sqlSession.update("quests.update", quest);
	}

}
