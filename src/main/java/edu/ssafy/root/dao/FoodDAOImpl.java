package edu.ssafy.root.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.root.food.Food;
import edu.ssafy.root.food.Nutrient;

@Repository("FoodDAOImpl")
public class FoodDAOImpl implements FoodDAO{
	
	@Autowired
	private SqlSession session;
	
	private FoodDAOImpl() {
	}
	
	@Override
	public int foodCount() {
		return session.selectOne("foody.getcount");
	}

	public List<Food> searchAll() {
		return session.selectList("foody.getlistall");
	}

	@Override
	public Food search(int fcode) {
		Food food = session.selectOne("foody.getfood", fcode);
		Nutrient nutri = session.selectOne("foody.getdetail", fcode);
		food.setNutrient(nutri.getNutri());
		return food;
	}

	@Override
	public List<Food> searchBest() {
		////////////////////////////////////// 세부사항 베스트 음식
//		return list;
		return null;
	}

	@Override
	public List<Food> searchByname(String fname) {
		return session.selectList("foody.getfoodbyname", fname);
	}

	@Override
	public void updateAllergy() {
		List<Food> li = searchAll();
		String[] all = {"대두","땅콩","우유","게","새우","참치","연어","쑥","소고기","닭고기","돼지고기","복숭아","민들레","계란흰자"};
		
		for(Food f : li) {
			String aList = f.getAllergyList();
			int cnt = 0;
			
			for(String str : all) {
				if(f.getFmaterial().contains(str)) {
					if(cnt == 0) {
						aList = str;
					} else {
						aList += ", "+str;
					}
					
					cnt++;
				}
			}
			if(f.getFmaterial().contains("원유")) {
				if(cnt == 0) {
					aList = "우유";
				} else {
					aList += ", 우유";
				}
				
				cnt++;
			}
			
			f.setAllergyList(aList);
			if(cnt > 0)
				session.update("foody.setAllergyList", f);
			System.out.println(f);
		}
	}

	@Override
	public int getMaxFcode() {
		return session.selectOne("foody.getMaxFcode");
	}

}
