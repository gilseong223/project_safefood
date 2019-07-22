package edu.ssafy.root.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.ssafy.root.qna.QNA;
import edu.ssafy.root.service.QNAService;

@Controller
@RequestMapping("/qna")
public class QNAController {
	
	@Autowired
	private QNAService serv;
	
	@RequestMapping("/list")
	public @ResponseBody List<QNA> qnaList() {
		return serv.searchAll();
	}
	
	@RequestMapping("/listByCategory/{category}")
	public @ResponseBody List<QNA> qnaListByCategory(@PathVariable String category){
		return serv.searchByCategory(category);
	}
	
	@RequestMapping("/listById/{mid}")
	public @ResponseBody List<QNA> qnaListById(@PathVariable String mid){
		return serv.searchById(mid);
	}
	
	@RequestMapping(value = "/ansRegister", method = {RequestMethod.POST, RequestMethod.GET},
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = "application/json",
			headers = "Accept=application/json")
	public @ResponseBody Map<String, Boolean> ansRegist(@RequestBody QNA qnaItem) throws Exception {
		if(serv.ansRegist(qnaItem)) {
			return Collections.singletonMap("result", true);
		} else {
			return Collections.singletonMap("result", false);
		}
	}
	
	@RequestMapping(value = "/qnaRegist", method = {RequestMethod.POST, RequestMethod.GET},
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = "application/json",
			headers = "Accept=application/json")
	public @ResponseBody Map<String, Boolean> qnaRegist(@RequestBody QNA qnaItem) throws Exception {
		if(serv.qnaRegist(qnaItem)) {
			return Collections.singletonMap("result", true);
		} else {
			return Collections.singletonMap("result", false);
		}
	}
	
	@RequestMapping(value = "/qnaDelete", method = {RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody Map<String, Boolean> qnaDelete(@RequestBody HashMap<String, Integer> m){
		if(serv.qnaDelete(m.get("seq"))) {
			return Collections.singletonMap("result", true);
		} else {
			return Collections.singletonMap("result", false);
		}
	}
	
	@RequestMapping(value = "/qnaUpdate", method = RequestMethod.POST)
	public @ResponseBody Map<String, Boolean> qnaUpdate(@RequestBody QNA qnaItem) {
		if(serv.qnaUpdate(qnaItem)) {
			return Collections.singletonMap("result", true);
		} else {
			return Collections.singletonMap("result", false);
		}
	}
	/*@RequestMapping(value = "/nav", method = {RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody Map<String, String> printNav(HttpSession sess) {
		Map<String, String> m = new HashMap<String, String>();
		m.put("navRef", callNav());
		m.put("mid", sess.getId());
		
		return m;
	}*/
	
	@RequestMapping(value = "/getId", method = {RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody Map<String, String> getMid(HttpSession sess) {
		return Collections.singletonMap("mid", (String) sess.getAttribute("ID"));
	}
	
	@RequestMapping(value = "/getQna", method = {RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody Map<String, QNA> getQna(HttpSession sess) {
		return Collections.singletonMap("qna", (QNA) sess.getAttribute("qna"));
	}
	
	@RequestMapping(value = "/goQNAUpdate", method = {RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody Map<String, Boolean> goQnaUpdate(HttpSession sess, @RequestBody QNA qnaItem) {
		if(qnaItem != null) {
			sess.setAttribute("qna", qnaItem);
			return Collections.singletonMap("result", true);
		} else {
			return Collections.singletonMap("result", false);
		}
	}
	
	/** Page redirection */
	@RequestMapping("/goQNARegist")
	public String qnaRegist() {
		return "redirect:/Resources/html/qnaRegist.html";
	}
	
	@RequestMapping("/goQNAList")
	public String goQNAList() {
		return "redirect:/Resources/html/QnA.html";
	}
	
	/*public String callNav() {
		return "/WEB-INF/views/navigation.jsp";
	}*/
	
	@RequestMapping(value = "/nav", method = {RequestMethod.POST, RequestMethod.GET})
	public String printNav() {
		return "navigation";
	}
	
}
