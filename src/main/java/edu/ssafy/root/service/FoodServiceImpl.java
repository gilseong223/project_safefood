package edu.ssafy.root.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ssafy.root.dao.FoodDAO;
import edu.ssafy.root.food.Food;
import edu.ssafy.root.member.Allergy;

@Service("FoodServiceImpl")
public class FoodServiceImpl implements FoodService{
	@Autowired
	private FoodDAO fdi;
	
	@Autowired
	private FoodsRecommendService recommendService;
	
	private FoodServiceImpl() {
	}
	
	@Override
	public int foodCount() {
		return fdi.foodCount();
	}

	@Override
	public List<Food> searchAll() {
//		처음 데이터 불러왔을 경우 allergy 정보 업데이트 함수
//		fdi.updateAllergy();
		return fdi.searchAll();
	}

	@Override
	public Food search(int code) {
		return fdi.search(code);
	}

	@Override
	public List<Food> searchBest() {
		return fdi.searchBest();
	}

	@Override
	public List<Food> searchByname(String name) {
		return fdi.searchByname(name);
	}

	@Override
	public List<Food> getRecommendedFood(int code, Allergy allergy, String mid) {
		return recommendService.getRecommendedFoods(code, allergy, mid);
	}

}
