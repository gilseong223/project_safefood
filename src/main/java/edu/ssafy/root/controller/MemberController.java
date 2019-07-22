package edu.ssafy.root.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.root.member.Allergy;
import edu.ssafy.root.member.MemberDetail;
import edu.ssafy.root.service.FoodService;
import edu.ssafy.root.service.MemberService;

@Controller("member")
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService msi;
	
	@Autowired
	private FoodService fsi;

	public MemberController() {}

	@RequestMapping("/addProduct")
	private void addProduct(HttpServletRequest request, HttpServletResponse response, ModelAndView model) throws ServletException, IOException {
//		Food find, int btnId, int fCnt, String userId
		
		/*System.out.println(request.getAttribute("btnId"));*/
		
		int code = Integer.parseInt(request.getParameter("code"));
		int btnId = Integer.parseInt(request.getParameter("btnId"));
		int fCnt = Integer.parseInt(request.getParameter("fCnt"));
		String id = (String) request.getSession().getAttribute("ID");
		String keyword = request.getParameter("keyword");
		System.out.println(keyword);
		
		msi.addProduct(code, btnId, fCnt, id);
		response.sendRedirect("/food/search?searchbox="+URLEncoder.encode(keyword));
		//request.getRequestDispatcher("/food/search").forward(request, response);
	}

	@RequestMapping("/detailDelete")
	private ModelAndView detailDelete(HttpServletRequest request, HttpServletResponse response, ModelAndView model) {
		String parse = request.getParameter("deleted");
		int fcode = Integer.parseInt(parse.split("\\.")[0]);
		String date = parse.split("\\.")[1];
		int time = Integer.parseInt(parse.split("\\.")[2]);
		String mid = (String) request.getSession().getAttribute("ID");
		
		msi.deleteEatFood(fcode, mid, date, time);
		
		model.setViewName("redirect:/member/memberEat");
		return model;
	}

	@RequestMapping("/memberEat")
	private ModelAndView memberEat(HttpServletRequest request, HttpServletResponse response, ModelAndView model) {
		HttpSession session = request.getSession();
		String ID = (String) session.getAttribute("ID");

		if (ID != null) {
			request.setAttribute("nutriSum", msi.sumEat(ID));
			request.setAttribute("detailList", msi.eatList(ID));
			request.setAttribute("foodList", fsi.searchAll());
			
			model.setViewName("memberDetail");
		} else
			model.setViewName("redirect:/");
		
		return model;
	}

	@RequestMapping("/memberDelete")
	private ModelAndView memberDelete(HttpServletRequest request, HttpServletResponse response, ModelAndView model) {
		String ID = request.getParameter("deleted");
//		System.out.println("--------------");
//		System.out.println(ID);
//		System.out.println("--------------");
		msi.delete(ID);
		
		
		return memberAdmin(request, response, model);
	}

	@RequestMapping("/memberLeave")
	private ModelAndView memberLeave(HttpServletRequest request, HttpServletResponse response, ModelAndView model) {
		String inputID = request.getParameter("ID");
		String inputPW = request.getParameter("PW");

		if (msi.login(inputID, inputPW)) {
			msi.delete(inputID);

			return memberLogout(request, response, model);
		} else {
			request.setAttribute("msg", "비밀번호가 틀렸습니다.");
			return memberMyPage(request, response, model);
		}
	}

	@RequestMapping("/memberAdmin")
	private ModelAndView memberAdmin(HttpServletRequest request, HttpServletResponse response, ModelAndView model) {
		HttpSession session = request.getSession();
		String admin = (String) session.getAttribute("ID");
		if (admin.equals("ssafy")) {
			request.setAttribute("list", msi.searchAll());
			
			model.setViewName("administrator");
		} else {
			model.setViewName("error");
		}
		return model;
	}
	
	@RequestMapping("/regMember")
	private ModelAndView regMember(ModelAndView model) {
		model.setViewName("regMember");
		
		return model;
	}

	@RequestMapping("/afterRegMember")
	private ModelAndView afterRegMember(HttpServletRequest request, HttpServletResponse response, ModelAndView model) {

		String ID = request.getParameter("id");
		if (msi.search(ID) != null) {
			request.setAttribute("msg", "이미 존재하는 아이디 입니다.");
			
			model.setViewName("regMember");
			return model;
		}
		String PW = request.getParameter("pw");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		if (PW.trim() == "" || name.trim() == "" || address.trim() == "" || phone.trim() == "") {
			request.setAttribute("msg", "제대로 입력해 주십시오.");
			
			model.setViewName("regMember");
			return model;
		}
		boolean[] allergy = new boolean[14];
		String[] checkedBox = request.getParameterValues("allergy");

		if (checkedBox.length > 0) {
			for (String cur : checkedBox) {
				allergy[Integer.parseInt(cur.split(" ")[1])] = true;
			}
		}
		
		Allergy al = new Allergy(allergy[0],allergy[1],allergy[2],allergy[3],allergy[4],allergy[5],allergy[6],allergy[7],allergy[8],allergy[9],allergy[10],allergy[11],allergy[12],allergy[13]);

		msi.add(ID, PW, name, address, phone, al, checkedBox);
		
		model.setViewName("redirect:/");
		return model;
	}

	@RequestMapping("/memberUpdate")
	private ModelAndView memberUpdate(HttpServletRequest request, HttpServletResponse response, ModelAndView model) {
		String inputID = request.getParameter("ID");
		String inputPW = request.getParameter("PW");
//		System.out.println(inputID + " " + inputPW);

		if (msi.login(inputID, inputPW)) {
			HttpSession session = request.getSession();
			session.setAttribute("ID", request.getParameter("ID"));
			session.setAttribute("name", msi.getName(inputID));
			session.setAttribute("member", msi.search(inputID));
			String ID = request.getParameter("ID");
			String PW = request.getParameter("PW");
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			boolean[] allergy = new boolean[15];
			
			String[] checkedBox = request.getParameterValues("allergy");

			if (checkedBox.length > 0) {
				for (String cur : checkedBox) {
					allergy[Integer.parseInt(cur.split(" ")[1])] = true;
				}
			}
			
			///////////
//			System.out.println(Arrays.toString(allergy));
			///////////
			
			Allergy al = new Allergy(allergy[0],allergy[1],allergy[2],allergy[3],allergy[4],allergy[5],allergy[6],allergy[7],allergy[8],allergy[9],allergy[10],allergy[11],allergy[12],allergy[13]);

			msi.modify(ID, PW, name, address, phone, al, checkedBox);

			model.setViewName("redirect:/");
		} else {
			model.setViewName("loginFail");
		}
		
		return model;
	}

	@RequestMapping("/memberMyPage")
	private ModelAndView memberMyPage(HttpServletRequest request, HttpServletResponse response, ModelAndView model) {
		HttpSession session = request.getSession();
		request.setAttribute("name", msi.getName((String) session.getAttribute("ID")));
		request.setAttribute("member", msi.search((String) session.getAttribute("ID")));
		
		/*System.out.println(msi.search((String) session.getAttribute("ID")));*/

		model.setViewName("myPage");
		return model;
	}

	@RequestMapping("/memberLogout")
	private ModelAndView memberLogout(HttpServletRequest request, HttpServletResponse response, ModelAndView model) {
		HttpSession session = request.getSession();
		session.setAttribute("ID", "null");
		
		model.setViewName("redirect:/");
		return model;
	}

	@RequestMapping("/memberLogin")
	private ModelAndView memberLogin(HttpServletRequest request, HttpServletResponse response, ModelAndView model) {
		String inputID = request.getParameter("ID");
		String inputPW = request.getParameter("PW");
		if (msi.login(inputID, inputPW)) {
			HttpSession session = request.getSession();
			session.setAttribute("ID", request.getParameter("ID"));
			session.setAttribute("name", msi.getName(inputID));

			model.setViewName("redirect:/");
		} else {
			model.setViewName("loginFail");
		}
		
		return model;
	}

}
