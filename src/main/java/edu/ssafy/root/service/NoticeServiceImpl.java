package edu.ssafy.root.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ssafy.root.dao.NoticeDAO;
import edu.ssafy.root.dao.NoticeDAOImpl;
import edu.ssafy.root.notice.Notice;

@Service("NoticeServiceImpl")
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	private NoticeDAO ndi;

	@Override
	public boolean add(Notice n) {
		return ndi.add(n);
	}

	@Override
	public boolean modify(Notice n) {
		return ndi.modify(n);
	}

	@Override
	public void delete(String seq) {
		ndi.delete(seq);
	}

	@Override
	public List<Notice> searchAll() {
		return ndi.searchAll();
	}

	@Override
	public List<Notice> searchByID(String id) {
		// TODO Auto-generated method stub
		return ndi.searchByID(id);
	}

	@Override
	public List<Notice> searchByTitle(String title) {
		// TODO Auto-generated method stub
		return ndi.searchByTitle(title);
	}

	@Override
	public Notice search(String seq) {
		return ndi.search(seq);
	}

}
