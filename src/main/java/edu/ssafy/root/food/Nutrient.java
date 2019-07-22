package edu.ssafy.root.food;

import java.io.Serializable;

public class Nutrient implements Serializable{
	private float nutrient1;
	private float nutrient2;
	private float nutrient3;
	private float nutrient4;
	private float nutrient5;
	private float nutrient6;
	private float nutrient7;
	private float nutrient8;
	private float nutrient9;
	
	public Nutrient(float nutrient1, float nutrient2, float nutrient3, float nutrient4, float nutrient5,
			float nutrient6, float nutrient7, float nutrient8, float nutrient9) {
		super();
		this.nutrient1 = nutrient1;
		this.nutrient2 = nutrient2;
		this.nutrient3 = nutrient3;
		this.nutrient4 = nutrient4;
		this.nutrient5 = nutrient5;
		this.nutrient6 = nutrient6;
		this.nutrient7 = nutrient7;
		this.nutrient8 = nutrient8;
		this.nutrient9 = nutrient9;
	}
	
	public float[] getNutri() {
		float[] list = new float[10];
		list[1] = nutrient1;
		list[2] = nutrient2;
		list[3] = nutrient3;
		list[4] = nutrient4;
		list[5] = nutrient5;
		list[6] = nutrient6;
		list[7] = nutrient7;
		list[8] = nutrient8;
		list[9] = nutrient9;
		
		return list;
	}
	
	public Nutrient() {
		super();
	}
	public float getNutrient1() {
		return nutrient1;
	}
	public void setNutrient1(float nutrient1) {
		this.nutrient1 = nutrient1;
	}
	public float getNutrient2() {
		return nutrient2;
	}
	public void setNutrient2(float nutrient2) {
		this.nutrient2 = nutrient2;
	}
	public float getNutrient3() {
		return nutrient3;
	}
	public void setNutrient3(float nutrient3) {
		this.nutrient3 = nutrient3;
	}
	public float getNutrient4() {
		return nutrient4;
	}
	public void setNutrient4(float nutrient4) {
		this.nutrient4 = nutrient4;
	}
	public float getNutrient5() {
		return nutrient5;
	}
	public void setNutrient5(float nutrient5) {
		this.nutrient5 = nutrient5;
	}
	public float getNutrient6() {
		return nutrient6;
	}
	public void setNutrient6(float nutrient6) {
		this.nutrient6 = nutrient6;
	}
	public float getNutrient7() {
		return nutrient7;
	}
	public void setNutrient7(float nutrient7) {
		this.nutrient7 = nutrient7;
	}
	public float getNutrient8() {
		return nutrient8;
	}
	public void setNutrient8(float nutrient8) {
		this.nutrient8 = nutrient8;
	}
	public float getNutrient9() {
		return nutrient9;
	}
	public void setNutrient9(float nutrient9) {
		this.nutrient9 = nutrient9;
	}
	@Override
	public String toString() {
		return "Nutrient [nutrient1=" + nutrient1 + ", nutrient2=" + nutrient2 + ", nutrient3=" + nutrient3
				+ ", nutrient4=" + nutrient4 + ", nutrient5=" + nutrient5 + ", nutrient6=" + nutrient6 + ", nutrient7="
				+ nutrient7 + ", nutrient8=" + nutrient8 + ", nutrient9=" + nutrient9 + "]";
	}
	
}
