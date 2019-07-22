package edu.ssafy.root.service;

import java.util.List;

import edu.ssafy.root.qna.QNA;

public interface QNAService {
	public List<QNA> searchAll();
	public List<QNA> searchByCategory(String category);
	public List<QNA> searchById(String Id);
	public boolean qnaRegist(QNA qnaItem);
	public boolean qnaUpdate(QNA qnaItem);
	public boolean ansRegist(QNA qnaItem);
	public boolean ansUpdate(QNA qnaItem);
	public boolean qnaDelete(int seq);
}
