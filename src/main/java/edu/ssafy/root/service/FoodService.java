package edu.ssafy.root.service;

import java.util.List;

import edu.ssafy.root.food.Food;
import edu.ssafy.root.member.Allergy;

public interface FoodService {

	public int foodCount();
	public List<Food> searchAll();
	public Food search(int code);
	public List<Food> searchByname(String name);
	public List<Food> searchBest();
	public List<Food> getRecommendedFood(int code, Allergy allergy, String mid);
}
