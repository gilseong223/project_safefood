package edu.ssafy.root.service;

import java.util.List;

import edu.ssafy.root.food.Food;
import edu.ssafy.root.member.Allergy;

public interface FoodsRecommendService {
	List<Food> getRecommendedFoods(int code, Allergy allergy, String mid);
}
