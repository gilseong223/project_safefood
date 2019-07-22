package edu.ssafy.root.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ssafy.root.dao.FoodDAO;
import edu.ssafy.root.dao.MemberDAO;
import edu.ssafy.root.food.Food;
import edu.ssafy.root.member.Allergy;
import edu.ssafy.root.member.MemberDetail;

@Service("FoodsRecommend")
public class FoodsRecommend implements FoodsRecommendService {
	private final double THRESHOLD = 0.01;
	
	@Autowired
	private MemberDAO mdi;
	@Autowired
	private FoodDAO fdi;
	
	public FoodsRecommend() {
		
	}
	@Override
	public List<Food> getRecommendedFoods(int code, Allergy allergy, String mid) {
//		가장 먼저, 강제 디버깅 테스트를 시킨 것에 대해 사죄의 말씀을 드립니다.
		
//		fcode를 인덱스로 쓰기 위해 food의 fcode에서 최대값을 받아옴.
		int boolSize = fdi.getMaxFcode()+1;
		
//		섭취정보를 받아온다. 섭취정보는 (음식, 아이디, 시간)이라는 정보를 쓰기 위해 필요하다. 
		List<MemberDetail> firstStep = mdi.eatList();
//		섭취정보를 boolean 행렬로 바꿔준다. 예를 들어 한 끼에 fcode 1,2를 먹었다면 [false, true, true, false, false, ---]로 될 것이다.
		Map<Meal, boolean[]> secondStep = getMatrix(firstStep, boolSize);
		
//		섭취정보를 보자
		/*System.out.println("한 사람이 한끼에 얼마나 먹었는지 행렬로 표시");
		int cnt=0;
		for (Meal meal : secondStep.keySet()) {
			System.out.print(cnt++ +" : ");
			for (boolean bool : secondStep.get(meal)) {
				if(bool)
					System.out.print("1 ");
				else 
					System.out.print("0 ");
			}
			System.out.println();
		}
		System.out.println("");*/
		
//		하나의 식품의 support 값이 우리가 지정한 기준 이상이라면 앞으로 계산해야하는 식품이다.
//		calculatable은 '계산가능한'의 의미로 썼으나 진짜 있는 단어인지는 모른다. 우리끼리만 이런 의미라고 공유하자.
//		기준보다 적을 경우, 두 가지 식품의 쌍으로 계산했을 때 역시 기준보다 적을 것이다.(계산량 줄이기)
//		여기에서는 계산할 것이다와 계산하지 않을 것이다로 결정되기 때문에 true, false로 표현한다.
		boolean[] calculatable = getSingleSupport(secondStep, boolSize);
		
//		Frequent는 빈발하게 일어난다는 의미이다.
//		calculatable이 true인 식품명을 출력
		/*System.out.println("하나 Frequent set");
		for (int i = 0; i < calculatable.length; i++) {
			if(calculatable[i]) {
				System.out.print(fdi.search(i).getFname()+" ");
			}
		}
		System.out.println();*/
		
//		이제 두 가지 식품의 쌍이 Frequent한지 알아봐야 한다.
//		가장 먼저 인덱스를 바꿔야한다. 기존의 인덱스(fcode)와 새로운 인덱스를 저장할 테이블을 만든다. 
//		여기서는 (새로운 인덱스, 기존 인덱스)의 배열로 나타낸다. 
//		ex) 
//		(0, 5) 
//		(1, 7)
//		(2, 10)
//		(3, 15)
//		이런식으로 저장이 된다.
		int tableSize = 0;
		for (boolean b : calculatable) {
			if(b) tableSize++;
		}
		int[] fcodeTable = new int[tableSize];
		
//		테이블을 만듦과 동시에 
//		calculatable이 true인 애들로 새로운 배열을 만든다.
		secondStep = getFcodeTable(fcodeTable, calculatable, secondStep, tableSize);
		
//		줄어든 식품 세트로 N*N의 2차원 배열을 만든다.
//		pairSupport는 
//			1	2	3	4	5
//		1	   0.2 0.1 0.1 0.2
//		2  0.2 	   0.2 0.3 0.1
//		3  0.1 0.2     0.0 0.0
//		4  0.1 0.3 0.0	   0.1
//		5  0.2 0.1 0.0 0.1
//		이런 형태로 나온다.
//		TODO : 여기에 safe score를 추가하면 완료될 것 같음 
		double[][] pairSupport = getPairSupport(fcodeTable, secondStep);
		
		/*System.out.println();
		System.out.println("2d array");
		for (int i = 0; i < pairSupport.length; i++) {
			for (int j = 0; j < pairSupport.length; j++) {
//				System.out.println(fdi.search(fcodeTable[i]).getFname()+", "+fdi.search(fcodeTable[j]).getFname()+" : "+pairSupport[i][j]);
				System.out.print(pairSupport[i][j] + " ");
			}
			System.out.println();
		}*/
		
		/*
		 
		  여기에 SafeScore 규칙을 정해서 pairSupport에 가중치를 더하면 돼. 
		  이곳에 쓰이는 index값은 fcodeTable[index]로 변환해서 FoodList에 넣어야 한다는 것 잊지 말게~
		  
		*/
		applySafetyScore(fcodeTable, pairSupport, code, allergy, mid);
		
		
		List<Food> recommededList = getFrequentPair(fcodeTable, pairSupport, code);

		
		
		
		return recommededList;
	}
	
	private void applySafetyScore(int[] fcodeTable, double[][] pairSupport, int code, Allergy allergy, String mid) {
		int pairSize = fcodeTable.length;
		int tableCode = 0;
		boolean isExist = false;
		
		for (int i = 0; i < pairSize; i++) {
			if(fcodeTable[i] == code) {
				tableCode = i;
				isExist = true;
				break;
			}
		}
		
		if(!isExist) return;
		
		
		if(mid != "") {
			String[] allergyList = {"대두","땅콩","우유","게","새우","참치","연어","쑥","소고기","닭고기","돼지고기","복숭아","민들레","계란흰자"};
			boolean[] checkAll = allergy.getAllergyList();
			
			/* 알레르기 있는게 음식에 들어가있다면 0점으로. 추천되지 않도록 */
			for(int i=0,size=pairSupport.length; i<size; i++) {
				String foodAllList = fdi.search(i+1).getAllergyList();
				
				if(pairSupport[tableCode][i] == 0)
					continue;
				
				for(int j=0; j<14; j++) {
					if(checkAll[j] && foodAllList.contains(allergyList[j])) {
						pairSupport[tableCode][i] = 0;
						break;
					}
				}
			}
		}
		
		/*
		 * 나트륨 40%부터 10% 당 pairSupport 10% 감소
		 * 콜레스트롤,트렌스지방 10%당 pairSupport 10% 감소
		 * 포화지방은 30%부터 10%당 10%감소
		 * 당류는 20%부터 10%당 10%감소
		 * 비율로 점수를 적용시킴.
		 */
		//{"칼로리","탄수화물","단백질","지방","당류","나트륨","콜레스테롤","포화지방산","트렌스지방"}
		double[] dailyNutri = {2500,300,54.5,53.3,100,2, 0.3,15,2};
		for(int i=0,size=pairSupport.length; i<size; i++) {
			if(pairSupport[tableCode][i] == 0)
				continue;
			
			float[] nutri = fdi.search(i+1).getNutrient();
			double rule = 1.0;
//			System.out.println("현재 "+i);
			if(nutri[5] / dailyNutri[4] > 0.2) {rule *= 1.0 - (nutri[5]/dailyNutri[4] - 0.2);}
			if(nutri[6] / dailyNutri[5] > 0.4) {rule *= 1.0 - (nutri[6]/dailyNutri[5] - 0.4);}
			if(nutri[7] / dailyNutri[6] > 0) {rule *= 1.0 - (nutri[7]/dailyNutri[6]);}
			if(nutri[8] / dailyNutri[7] > 0.3) {rule *= 1.0 - (nutri[8]/dailyNutri[7] - 0.3);}
			if(nutri[9] / dailyNutri[8] > 0) {rule *= 1.0 - (nutri[9]/dailyNutri[8]);}
			if(rule < 0) rule = 0;
			
			pairSupport[tableCode][i] *= rule;
		}
	}
	private List<Food> getFrequentPair(int[] fcodeTable, double[][] pairSupport, int code) {
		List<Food> list = new ArrayList<Food>();
		int pairSize = fcodeTable.length;
		int tableCode = 0;
		boolean isExist = false;
		
		for (int i = 0; i < pairSize; i++) {
			if(fcodeTable[i] == code) {
				tableCode = i;
				isExist = true;
				break;
			}
		}
		
		if(!isExist) return new ArrayList<Food>();
		
		dummy[] tmpList = new dummy[4];
		for(int i=0; i<4; i++) {
			tmpList[i] = new dummy();
		}
		int tmpSize = 0;
		
		for (int j = 0; j < pairSize; j++) {
//			System.out.println(pairSupport[tableCode][j]);
			if (pairSupport[tableCode][j] >= THRESHOLD) {
				
				if(tmpSize == 0) {
					tmpList[0] = new dummy(pairSupport[tableCode][j], j);
					tmpSize++;
				} else if (tmpSize < 4) {
					for(int i=0; i<tmpSize; i++) {
						if(tmpList[i].pair <= pairSupport[tableCode][j]) {
							for(int k=tmpSize-1; k>=i; k--) {
								tmpList[k+1] = tmpList[k];
							}
							tmpList[i] = new dummy(pairSupport[tableCode][j], j);
							tmpSize++;
							break;
						}
					}
				} else {
					for(int i=0; i<tmpSize; i++) {
						if(tmpList[i].pair <= pairSupport[tableCode][j]) {
							for(int k=tmpSize-2; k>=i; k--) {
								tmpList[k+1] = tmpList[k];
							}
							tmpList[i] = new dummy(pairSupport[tableCode][j], j);
							break;
						}
					}
				}
				
//				list.add(fdi.search(fcodeTable[j]));
			}
		}
		
		if(tmpSize > 0) {
			Arrays.sort(tmpList);
			for(int i=0; i<tmpSize; i++) {
				list.add(fdi.search(tmpList[i].idx+1));
//				System.out.print(tmpList[i].pair+" ");
			}
		}
		
		return list;
	}

	private Map<Meal, boolean[]> getFcodeTable(int[] fcodeTable, boolean[] calculatable, Map<Meal, boolean[]> map, int tableSize) {
		int idx;
		for (Meal oneEat : map.keySet()) {
			boolean[] foodSet = map.get(oneEat);
			boolean[] newFoodSet = new boolean[tableSize];
			
			idx = 0;
			for (int i = 0, size=calculatable.length; i < size; i++) {
				if(calculatable[i]) {
					if(foodSet[i]) {
						newFoodSet[idx] = true;
					}
					idx++;
				}
			}
			map.put(oneEat, newFoodSet);
		}
		
		idx = 0;
		
		for (int i = 0, size=calculatable.length; i < size; i++) {
			if(calculatable[i]) {
				fcodeTable[idx] = i;
				idx++;
			}
		}
		return map;
	}

	private double[][] getPairSupport(int[] fcodeTable, Map<Meal, boolean[]> map) {
		boolean[] foodSet;
		int pairSize = fcodeTable.length;
		double[][] pairSupportDouble = new double[pairSize][pairSize];
		int[][] pairSupport = new int[pairSize][pairSize];
		int transactionCnt = map.size();
		
		for (Meal oneEat : map.keySet()) {
			foodSet = map.get(oneEat);
			getPair(pairSupport, foodSet, 0, 0, -1, -1);
		}
		
		for (int i = 0; i < pairSize; i++) {
			for (int j = 0; j < pairSize; j++) {
				pairSupportDouble[i][j] = (double)pairSupport[i][j] / transactionCnt;
			}
		}
		
		return pairSupportDouble;
	}

	private void getPair(int[][] pairSupport, boolean[] foodSet, int cnt, int idx, int x, int y) {
		if(cnt >= 2) {
			pairSupport[x][y]++;
			pairSupport[y][x]++;
			return;
		}
		
		for (int i = idx, size = foodSet.length; i < size; i++) {
			if(foodSet[i]) {
				if(cnt==0) {
					getPair(pairSupport, foodSet, cnt+1, i+1, i, y);
				}
				else {
					getPair(pairSupport, foodSet, cnt+1, i+1, x, i);
				}
			}
		}
	}

	private boolean[] getSingleSupport(Map<Meal, boolean[]> secondStep, int boolSize) {
		boolean[] foodSet;
		boolean[] calculatableSet = new boolean[boolSize];
		int[] supportSet = new int[boolSize];
		int transactionCnt = secondStep.size();

		for (Meal oneEat : secondStep.keySet()) {
			foodSet = secondStep.get(oneEat);
			for (int i = 0, size = foodSet.length; i < size; i++) {
				if(foodSet[i]) {
					supportSet[i]++;
				}
			}
		}
//		System.out.println();
//		System.out.println("supportSet : ");
//		for (int i : supportSet) {
//			System.out.print(i+" ");
//		}
//		System.out.println();
//		
		for(int i=0, size = supportSet.length; i<size; i++ ) {
//			System.out.println(i+"의 support값 : " + (double)supportSet[i]/transactionCnt);
			if((double)supportSet[i]/transactionCnt > THRESHOLD) {
				calculatableSet[i] = true;
			}
		}
//		System.out.println();
		
		return calculatableSet;
	}

	private Map<Meal, boolean[]> getMatrix(List<MemberDetail> list, int boolSize) {
		Map<Meal, boolean[]> map = new HashMap<Meal, boolean[]>();
		
		boolean isApplied = false;
		
		for (MemberDetail detail : list) {
			isApplied = false;
			
			for (Meal oneEat : map.keySet()) {
				if(oneEat.getMid().equals(detail.getMid()) && oneEat.getDate().equals(detail.getDate()) && oneEat.getTime() == detail.getTime()) {
					map.get(oneEat)[detail.getFcode()] = true;
					isApplied = true;
					break;
				}
			}
			
			if(!isApplied) {
				Meal today = new Meal(detail.getMid(), detail.getDate(), detail.getTime());
				boolean[] foodSet = new boolean[boolSize];
				foodSet[detail.getFcode()] = true;
				map.put(today, foodSet);
			}
		}
		
		return map;
	}
	
	
	static class dummy implements Comparable<dummy> {
		double pair;
		int idx;
		
		public dummy() {}
		public dummy(double pair, int idx) {
			this.pair = pair;
			this.idx = idx;
		}

		@Override
		public int compareTo(dummy o) {
			if(this.pair < o.pair) return 1;
			else if(this.pair > o.pair) return -1; 
			else return 0;
		}

	}
}