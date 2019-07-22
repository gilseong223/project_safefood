package edu.ssafy.root.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ssafy.root.dao.QNADAO;
import edu.ssafy.root.qna.QNA;

@Service
public class QNAServiceImpl implements QNAService {

	@Autowired
	private QNADAO dao;
	
	@Override
	public List<QNA> searchAll() {
		return dao.searchAll();
	}

	@Override
	public List<QNA> searchByCategory(String category) {
		return dao.searchByCategory(category);
	}

	@Override
	public List<QNA> searchById(String Id) {
		return dao.searchById(Id);
	}

	@Override
	public boolean qnaRegist(QNA qnaItem) {
		return dao.qnaRegist(qnaItem);
	}

	@Override
	public boolean qnaUpdate(QNA qnaItem) {
		return dao.qnaUpdate(qnaItem);
	}

	@Override
	public boolean qnaDelete(int seq) {
		return dao.qnaDelete(seq);
	}

	@Override
	public boolean ansRegist(QNA qnaItem) {
		return dao.ansRegist(qnaItem);
	}

	@Override
	public boolean ansUpdate(QNA qnaItem) {
		return dao.ansUpdate(qnaItem);
	}

}
