package edu.ssafy.root.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.root.notice.Notice;

@Repository("NoticeDAOImpl")
public class NoticeDAOImpl implements NoticeDAO {
	
	@Autowired
	SqlSession session;

	@Override
	public boolean add(Notice n) {
		session.insert("noti.insertNotice", n);
		return false;
	}

	@Override
	public boolean modify(Notice n) {
		if(session.update("noti.updateNotice", n) > 0) 
			return true;
		return false;
	}

	@Override
	public void delete(String seq) {
		session.delete("noti.deleteNotice", seq);
	}

	@Override
	public List<Notice> searchAll() {
		return session.selectList("noti.searchAll");
	}

	@Override
	public List<Notice> searchByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Notice> searchByTitle(String title) {
		return session.selectList("noti.searchByTitle", title);
	}

	@Override
	public Notice search(String seq) {
		return session.selectOne("noti.search", seq);
	}

}
