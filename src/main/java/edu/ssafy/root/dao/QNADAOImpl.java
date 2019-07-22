package edu.ssafy.root.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.root.qna.QNA;

@Repository
public class QNADAOImpl implements QNADAO {

	@Autowired
	SqlSession session;
	
	@Override
	public List<QNA> searchAll() {
		return session.selectList("qna.searchAll");
	}

	@Override
	public List<QNA> searchByCategory(String category) {
		return session.selectList("qna.searchByCategory", category);
	}

	@Override
	public List<QNA> searchById(String mid) {
		return session.selectList("qna.searchById", mid);
	}

	@Override
	public boolean qnaRegist(QNA qnaItem) {
		int ret = session.insert("qna.regist", qnaItem);
		
		if(ret > 0) return true;
		else return false;
	}

	@Override
	public boolean qnaUpdate(QNA qnaItem) {
		int ret = session.update("qna.updateQ", qnaItem);
		
		if(ret > 0) return true;
		else return false;
	}

	@Override
	public boolean qnaDelete(int seq) {
		int ret = session.delete("qna.delete", seq);
		
		if(ret > 0) return true;
		else return false;
	}

	@Override
	public boolean ansRegist(QNA qnaItem) {
		int ret = session.insert("qna.registA", qnaItem);
		
		if(ret > 0) return true;
		else return false;
	}

	@Override
	public boolean ansUpdate(QNA qnaItem) {
		int ret = session.update("qna.updateA", qnaItem);
		
		if(ret > 0) return true;
		else return false;
	}

}
