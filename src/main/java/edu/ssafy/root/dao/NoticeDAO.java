package edu.ssafy.root.dao;

import java.util.ArrayList;
import java.util.List;

import edu.ssafy.root.notice.Notice;

public interface NoticeDAO {

	public boolean add(Notice n);
	public boolean modify(Notice n);
	public void delete(String seq);
	public Notice search(String seq);
	public List<Notice> searchAll();
	public List<Notice> searchByID(String id);
	public List<Notice> searchByTitle(String title);
	
}
