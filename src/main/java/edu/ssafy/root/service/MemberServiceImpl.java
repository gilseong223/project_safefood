package edu.ssafy.root.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ssafy.root.dao.MemberDAO;
import edu.ssafy.root.food.Food;
import edu.ssafy.root.member.Allergy;
import edu.ssafy.root.member.Member;
import edu.ssafy.root.member.MemberDetail;
import edu.ssafy.root.member.eatListDTO;

@Service("MemberServiceImpl")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO mdi;
	
	private MemberServiceImpl() {}

	@Override
	public void add(String ID, String PW, String name, String address, String phone, Allergy allergy, String[] checkedBox) {
		Member m = new Member(ID, PW, name, address, phone, allergy);
		mdi.add(m);
	}

	@Override
	public void delete(String id) {
		mdi.delete(id);
	}

	@Override
	public Member search(String id) {
		return mdi.search(id);
	}

	@Override
	public boolean login(String id, String pw) {
		if (mdi.getSize() > 0 && mdi.search(id) != null && pw.equals(mdi.search(id).getPW())) {
			return true;
		}
		return false;
	}
	
	@Override
	public String getName(String id) {
		return mdi.getName(id);
	}

	@Override
	public boolean addProduct(int fcode, int btnId, int fCnt, String userId) {
		return mdi.addProduct(fcode, btnId, fCnt, userId);
	}
	
	@Override
	public boolean modify(String iD, String pW, String name, String address, String phone, Allergy allergy,
			String[] checkedBox) {
		Member m = new Member(iD, pW, name, address, phone, allergy);
		
		////////////
		System.out.println("service : "+m.getAllergy());
		////////////
		
		return mdi.modify(m);
	}

	@Override
	public List<Member> searchAll() {
		return mdi.searchAll();
	}

	@Override
	public List<eatListDTO> eatList(String id) {
		return mdi.eatList(id);
	}

	@Override
	public void deleteEatFood(int fcode, String mid, String date, int time) {
		MemberDetail md = new MemberDetail(fcode, mid, date, time, 0);
		mdi.deleteEatFood(md);
	}

	@Override
	public double[] sumEat(String id) {
		return mdi.sumEat(id);
	}

}
