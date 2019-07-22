package edu.ssafy.root.dao;

import java.util.List;

import edu.ssafy.root.food.Food;
import edu.ssafy.root.member.Member;
import edu.ssafy.root.member.MemberDetail;
import edu.ssafy.root.member.eatListDTO;

public interface MemberDAO {

	public boolean add(Member m);
	public boolean modify(Member m);
	public void delete(String id);
	public Member search(String id);
	public int getSize();
	public String getName(String id);
	public boolean addProduct(int fcode, int btnId, int fCnt, String userId);
	public List<Member> searchAll();
//	섭취 정보
	public List<eatListDTO> eatList(String id);
	public void deleteEatFood(MemberDetail md);
	public double[] sumEat(String id);
	public List<MemberDetail> eatList();
}
