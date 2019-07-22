package edu.ssafy.root.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.root.food.Food;
import edu.ssafy.root.member.Allergy;
import edu.ssafy.root.member.Member;
import edu.ssafy.root.member.MemberDetail;
import edu.ssafy.root.member.eatListDTO;

@Repository("MemberDAOImpl")
public class MemberDAOImpl implements MemberDAO{

//	private MemberDAOImpl() {
//		list = new ArrayList<Member>();
//		list.add(new Member("ssafy","1111","admin","default","010-0000-0000",new boolean[14]));
//	}
	
	@Autowired
	private SqlSession session;
	
	@Autowired
	private FoodDAO fdo;
	
	@Override
	public boolean add(Member m) {
//		int ret = session.insert("mem.add", m);
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ID", m.getID());
		param.put("PW", m.getPW());
		param.put("name",m.getName());
		param.put("address", m.getAddress());
		param.put("phone", m.getPhone());
		param.put("allergy", m.getAllergy());
		int ret = session.insert("mem.add", param);
		
		if(ret > 0) return true;
		else return false;
	}

	@Override
	public boolean modify(Member m) {
		/*int ret = session.update("mem.modify", m);*/
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ID", m.getID());
		param.put("name",m.getName());
		param.put("address", m.getAddress());
		param.put("phone", m.getPhone());
		
		Allergy allergy = m.getAllergy();
		
		////////////
		System.out.println("dao : "+allergy);
		////////////
		
		param.put("allergy", allergy);
		
		int ret = session.update("mem.modify", param);
	
		if(ret > 0) return true;
		else return false;
	}

	@Override
	public void delete(String ID) {
		session.delete("mem.delete", ID);
	}

	@Override
	public Member search(String ID) {
		Member result = session.selectOne("mem.search", ID);
		Allergy aller = session.selectOne("mem.searchAfter", ID);
		
		if(result != null)
			result.setAllergy(aller);
		
		return result;
	}

	@Override
	public int getSize() {
		return session.selectOne("mem.getSize");
	}

	@Override
	public String getName(String ID) {
		return session.selectOne("mem.getName", ID);
	}

	public boolean addProduct(int fcode, int btnId, int fCnt, String userId) {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String str = dateFormat.format(cal.getTime());
		
		DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal2 = Calendar.getInstance();
		String str2 = dateFormat2.format(cal2.getTime());
		
		MemberDetail memdetail = new MemberDetail(fcode, userId, str, btnId, fCnt);
		MemberDetail find = session.selectOne("memdetail.searchAddProduct", new MemberDetail(fcode, userId, str2, btnId));
		if(find == null) {
			int ret = session.insert("memdetail.insert", memdetail);
			
			if(ret > 0) return true;
			else return false;
		} else {
			memdetail.setCnt(memdetail.getCnt() + find.getCnt());
			session.delete("memdetail.delete2", find);
			int ret = session.insert("memdetail.insert", memdetail);
			
			if(ret > 0) return true;
			else return false;
		}
	}

	@Override
	public List<Member> searchAll() {
		return session.selectList("mem.searchAll");
	}

	@Override
	public List<eatListDTO> eatList(String ID) {
		return session.selectList("mem.eatList", ID);
	}
	/*public List<MemberDetail> eatList(String ID) {
		return session.selectList("mem.eatList", ID);
	}*/

	@Override
	public void deleteEatFood(MemberDetail md) {
		session.delete("mem.deleteEatFood", md);
	}

	@Override
	public double[] sumEat(String ID) {
		double[] sumeat = new double[10];
		int cnt=0, code;
		float[] eat;
		for (eatListDTO md : eatList(ID)) {
			cnt = md.getCnt();
			code = md.getFcode();
			eat = fdo.search(code).getNutrient();
			sumeat[0] += eat[1] * cnt;
			sumeat[1] += eat[2] * cnt;
			sumeat[2] += eat[3] * cnt;
			sumeat[3] += eat[4] * cnt;
			sumeat[4] += eat[5] * cnt;
			sumeat[5] += eat[6] * cnt;
			sumeat[6] += eat[7] * cnt;
			sumeat[7] += eat[8] * cnt;
			sumeat[8] += eat[9] * cnt;
		}
		
		return sumeat;
	}

	@Override
	public List<MemberDetail> eatList() {
		return session.selectList("mem.eatAll");
	}

}
