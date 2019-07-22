package edu.ssafy.root.service;

import java.util.List;

import edu.ssafy.root.food.Food;
import edu.ssafy.root.member.Allergy;
import edu.ssafy.root.member.Member;
import edu.ssafy.root.member.MemberDetail;
import edu.ssafy.root.member.eatListDTO;

public interface MemberService {

	void add(String ID, String PW, String name, String address, String phone, Allergy allergy, String[] checkedBox);
	public boolean modify(String iD, String pW, String name, String address, String phone, Allergy allergy, String[] checkedBox);
	public void delete(String id);
	public Member search(String id);
	public String getName(String id);
	public boolean login(String id, String pw);
	public boolean addProduct(int fcode, int btnId, int fCnt, String userId);
	public List<Member> searchAll();
//	섭취 정보
	public List<eatListDTO> eatList(String id);
	public void deleteEatFood(int fcode, String mid, String date, int time);
	public double[] sumEat(String id);
}
