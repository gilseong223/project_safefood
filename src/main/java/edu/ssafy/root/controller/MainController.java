package edu.ssafy.root.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.root.service.FoodServiceImpl;

@Controller()
public class MainController {
	private MainController() {}
	
	@Autowired
	private FoodServiceImpl fsi;

	@RequestMapping("/")
	public ModelAndView go(HttpServletRequest request, HttpServletResponse response, ModelAndView model) {
		
		request.setAttribute("list", fsi.searchAll());

		HttpSession session = request.getSession();
		if(session.getAttribute("ID") != null && !session.getAttribute("ID").equals("null")) {
			request.setAttribute("ID", session.getAttribute("ID"));
		} else {
			session.setAttribute("ID", "null");
		}
		
		model.setViewName("main");
		
		return model;
	}
}
