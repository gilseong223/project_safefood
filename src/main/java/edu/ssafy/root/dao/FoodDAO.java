package edu.ssafy.root.dao;

import java.util.List;

import edu.ssafy.root.food.Food;

public interface FoodDAO {

	public int foodCount();
	public List<Food> searchAll();
	public Food search(int code);
	public List<Food> searchByname(String name);
	public List<Food> searchBest();
	public void updateAllergy();
	public int getMaxFcode();
	
}
