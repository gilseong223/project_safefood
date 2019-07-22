package edu.ssafy.root.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.root.food.Food;
import edu.ssafy.root.member.Allergy;
import edu.ssafy.root.service.FoodService;
import edu.ssafy.root.service.MemberService;

@Controller("food")
@RequestMapping("/food")
public class FoodController {
	@Autowired
	private FoodService ser;
	
	@Autowired
	private MemberService mser;
	
	private FoodController() {}

	@RequestMapping("/detail")
	private ModelAndView foodDetail(HttpServletRequest request, ModelAndView model) {
		int code = Integer.parseInt(request.getParameter("code"));
		Food food = ser.search(code);
		model.addObject("food", food);
		
		String mid = (String) request.getSession().getAttribute("ID");
		if(mid == null) {
			mid = "";
		}
		
		Allergy tmpAll;
		if(mser.search(mid) == null) {
			tmpAll = new Allergy(false,false,false,false,false,false,false,false,false,false,false,false,false,false);
		} else {
			tmpAll = mser.search(mid).getAllergy();
		}
		List<Food> recommendedFoodList = ser.getRecommendedFood(code, tmpAll, mid);
		System.out.println("size : " + recommendedFoodList.size());
		for (Food food2 : recommendedFoodList) {
			System.out.println(food2);
		}
		
		model.addObject("recommendedFoods", recommendedFoodList);
		
		model.setViewName("foodDetail");
		return model;
	}

	@RequestMapping("/search")
	private ModelAndView foodSearch(HttpServletRequest request, ModelAndView model) {
		String keyword = request.getParameter("searchbox");
		if(keyword == null)
			keyword = "";
		model.addObject("keyword", keyword);
		
		if(keyword == null || keyword.equals("")) {
			model.addObject("list", ser.searchAll());
			List<Food> list = ser.searchAll();
//			for (Food food : list) {
//				System.out.println(food.toString());
//			}
		} else {
			model.addObject("list", ser.searchByname(keyword));
		}
		model.setViewName("foodList");
		return model;
	}
	
	
	@RequestMapping(value = "/getFood/{fCode}", method = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT})
	private @ResponseBody Map<String, Object> getFood(@PathVariable int fCode){//@RequestBody Map<String, Object> m){
		System.out.println("Check");
		
		Map<String, Object> ret = new HashMap<String, Object>();
		//int fCode = Integer.parseInt((String) m.get("curFood"));
//		System.out.println(fCode);
		
		Food f = ser.search(fCode);
//		System.out.println(f);
		ret.put("allergy", f.getAllergyList());
		ret.put("foodMaterial", f.getFmaterial());
		ret.put("foodNutrient", f.getNutrient());
//		System.out.println("no");
		return ret;
	}
	
}