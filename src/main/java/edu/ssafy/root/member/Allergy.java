package edu.ssafy.root.member;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Allergy implements Serializable{
	private boolean allergy1;
	private boolean allergy2;
	private boolean allergy3;
	private boolean allergy4;
	private boolean allergy5;
	private boolean allergy6;
	private boolean allergy7;
	private boolean allergy8;
	private boolean allergy9;
	private boolean allergy10;
	private boolean allergy11;
	private boolean allergy12;
	private boolean allergy13;
	private boolean allergy14;
	
	public boolean[] getAllergyList() {
		boolean[] aList = new boolean[14];
		
		if(allergy1) aList[0] = true;
		if(allergy2) aList[1] = true;
		if(allergy3) aList[2] = true;
		if(allergy4) aList[3] = true;
		if(allergy5) aList[4] = true;
		if(allergy6) aList[5] = true;
		if(allergy7) aList[6] = true;
		if(allergy8) aList[7] = true;
		if(allergy9) aList[8] = true;
		if(allergy10) aList[9] = true;
		if(allergy11) aList[10] = true;
		if(allergy12) aList[11] = true;
		if(allergy13) aList[12] = true;
		if(allergy14) aList[13] = true;
		
		return aList;
	}

	public Allergy(boolean allergy1, boolean allergy2, boolean allergy3, boolean allergy4, boolean allergy5,
			boolean allergy6, boolean allergy7, boolean allergy8, boolean allergy9, boolean allergy10,
			boolean allergy11, boolean allergy12, boolean allergy13, boolean allergy14) {
		super();
		this.allergy1 = allergy1;
		this.allergy2 = allergy2;
		this.allergy3 = allergy3;
		this.allergy4 = allergy4;
		this.allergy5 = allergy5;
		this.allergy6 = allergy6;
		this.allergy7 = allergy7;
		this.allergy8 = allergy8;
		this.allergy9 = allergy9;
		this.allergy10 = allergy10;
		this.allergy11 = allergy11;
		this.allergy12 = allergy12;
		this.allergy13 = allergy13;
		this.allergy14 = allergy14;
	}

	public Allergy() {
		super();
	}
	
	public boolean checkAllergy(int idx) {
		switch(idx) {
		case 1:
			return allergy1;
		case 2:
			return allergy2;
		case 3:
			return allergy3;
		case 4:
			return allergy4;
		case 5:
			return allergy5;
		case 6:
			return allergy6;
		case 7:
			return allergy7;
		case 8:
			return allergy8;
		case 9:
			return allergy9;
		case 10:
			return allergy10;
		case 11:
			return allergy11;
		case 12:
			return allergy12;
		case 13:
			return allergy13;
		case 14:
			return allergy14;
		default:
			return false;
		}
	}
	
	public boolean getAllergy1() {
		return allergy1;
	}

	public void setAllergy1(boolean allergy1) {
		this.allergy1 = allergy1;
	}

	public boolean getAllergy2() {
		return allergy2;
	}

	public void setAllergy2(boolean allergy2) {
		this.allergy2 = allergy2;
	}

	public boolean getAllergy3() {
		return allergy3;
	}

	public void setAllergy3(boolean allergy3) {
		this.allergy3 = allergy3;
	}

	public boolean getAllergy4() {
		return allergy4;
	}

	public void setAllergy4(boolean allergy4) {
		this.allergy4 = allergy4;
	}

	public boolean getAllergy5() {
		return allergy5;
	}

	public void setAllergy5(boolean allergy5) {
		this.allergy5 = allergy5;
	}

	public boolean getAllergy6() {
		return allergy6;
	}

	public void setAllergy6(boolean allergy6) {
		this.allergy6 = allergy6;
	}

	public boolean getAllergy7() {
		return allergy7;
	}

	public void setAllergy7(boolean allergy7) {
		this.allergy7 = allergy7;
	}

	public boolean getAllergy8() {
		return allergy8;
	}

	public void setAllergy8(boolean allergy8) {
		this.allergy8 = allergy8;
	}

	public boolean getAllergy9() {
		return allergy9;
	}

	public void setAllergy9(boolean allergy9) {
		this.allergy9 = allergy9;
	}

	public boolean getAllergy10() {
		return allergy10;
	}

	public void setAllergy10(boolean allergy10) {
		this.allergy10 = allergy10;
	}

	public boolean getAllergy11() {
		return allergy11;
	}

	public void setAllergy11(boolean allergy11) {
		this.allergy11 = allergy11;
	}

	public boolean getAllergy12() {
		return allergy12;
	}

	public void setAllergy12(boolean allergy12) {
		this.allergy12 = allergy12;
	}

	public boolean getAllergy13() {
		return allergy13;
	}

	public void setAllergy13(boolean allergy13) {
		this.allergy13 = allergy13;
	}

	public boolean getAllergy14() {
		return allergy14;
	}

	public void setAllergy14(boolean allergy14) {
		this.allergy14 = allergy14;
	}

	public List<Boolean> getAll(){
		List<Boolean> li = new ArrayList<Boolean>();
		li.add(this.allergy1);
		li.add(this.allergy2);
		li.add(this.allergy3);
		li.add(this.allergy4);
		li.add(this.allergy5);
		li.add(this.allergy6);
		li.add(this.allergy7);
		li.add(this.allergy8);
		li.add(this.allergy9);
		li.add(this.allergy10);
		li.add(this.allergy11);
		li.add(this.allergy12);
		li.add(this.allergy13);
		li.add(this.allergy14);
		
		return li;
	}

	@Override
	public String toString() {
		return "Allergy [allergy1=" + allergy1 + ", allergy2=" + allergy2 + ", allergy3=" + allergy3
				+ ", allergy4=" + allergy4 + ", allergy5=" + allergy5 + ", allergy6=" + allergy6 + ", allergy7="
				+ allergy7 + ", allergy8=" + allergy8 + ", allergy9=" + allergy9 + ", allergy10=" + allergy10
				+ ", allergy11=" + allergy11 + ", allergy12=" + allergy12 + ", allergy13=" + allergy13 + ", allergy14="
				+ allergy14 + "]";
	}
	
	

}
