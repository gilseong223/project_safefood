package edu.ssafy.root.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.root.notice.Notice;
import edu.ssafy.root.page.Pagination;
import edu.ssafy.root.service.NoticeService;

@Controller("NoticeController")
@RequestMapping("/notice")
public class NoticeController {
	
	@Autowired
	private NoticeService nsi;
	
	@RequestMapping("/noticeList")
	private ModelAndView noticeList(@RequestParam(defaultValue="1") int curPage, ModelAndView model) {
		List<Notice> list = nsi.searchAll();
		int listCnt = list.size();
		
		Pagination pagination = new Pagination(listCnt, curPage);
		int startIdx = pagination.getPageSize() * (curPage-1);
		int endIdx = startIdx + pagination.getPageSize();
		if(endIdx > listCnt) endIdx = listCnt;
		List<Notice> parsedList = list.subList(startIdx, endIdx);
		
		model.addObject("pagination", pagination);
		model.addObject("noticeList", parsedList);
		model.addObject("listCnt", listCnt);
		
		model.setViewName("noticeList");
		
		return model;
	}
	
	@RequestMapping("/register")
	private ModelAndView goRegister(ModelAndView model) {
		model.setViewName("noticeRegister");
		return model;
	}
	
	@RequestMapping("/noticeRegister")
	private ModelAndView noticeRegister(Notice notice, ModelAndView model) {
		System.out.println(notice);
		
		nsi.add(notice);
		return noticeList(1, model);
	}
	
	@RequestMapping("/noticeContent")
	private ModelAndView goContents(HttpServletRequest request, ModelAndView model) {
		String action = request.getParameter("contentNo");
		
		model.addObject("content", nsi.search(action));
		model.setViewName("noticeContent");
		return model;
	}
	
	@RequestMapping("/goNoticeUpdate")
	private ModelAndView gonoticeUpdate(HttpServletRequest request, ModelAndView model) {
		String action = request.getParameter("seq");
		
		model.addObject("content", nsi.search(action));
		model.setViewName("noticeUpdate");
		return model;
	}
	
	@RequestMapping("/noticeUpdate")
	private ModelAndView noticeUpdate(Notice n, ModelAndView model) {
		nsi.modify(n);
		return noticeList(1, model);
	}
	
	@RequestMapping("/noticeDelete")
	private ModelAndView noticeDelete(HttpServletRequest request, ModelAndView model) {
		String action = request.getParameter("contentNo");
		nsi.delete(action);
		return noticeList(1, model);
	}
	
	@RequestMapping("/searchByName")
	private ModelAndView searchByName(@RequestParam(defaultValue="1") int curPage, HttpServletRequest request, ModelAndView model) {
		System.out.println("curPage : "+curPage);
		String action = request.getParameter("jinsu");
		action="";
		System.out.println("jinsu : "+ action+", curPage : "+curPage);
		
		model.addObject("noticeList", nsi.searchByTitle(action));
		model.addObject("jinsu", action);
		model.setViewName("noticeList");
		List<Notice> list = nsi.searchByTitle(action);
		
		
		int listCnt = list.size();
		Pagination pagination = new Pagination(listCnt, curPage);
		int startIdx = pagination.getPageSize() * (curPage-1);
		int endIdx = startIdx + pagination.getPageSize();
		if(endIdx > listCnt) endIdx = listCnt;
		List<Notice> parsedList = list.subList(startIdx, endIdx);
		
		model.addObject("pagination", pagination);
		model.addObject("noticeList", parsedList);
		model.addObject("listCnt", listCnt);
		
		return model;
	}
}
