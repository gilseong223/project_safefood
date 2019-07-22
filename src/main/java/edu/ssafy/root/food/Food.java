package edu.ssafy.root.food;

import java.io.Serializable;
import java.util.Arrays;

public class Food implements Serializable{
	private int fcode;
	private String fname;
	private String fmaker;
	private String fmaterial;
	private String fimage;
	private String year;
	private String allergyList;
	private float[] nutrient;
	
	public String getAllergyList() {
		return this.allergyList;
	}
	
	public void setAllergyList(String allergyList) {
		this.allergyList = allergyList;
	}
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public Food(int fcode, String fname, String fmaker, String fmaterial, String fimage, String year,
			float[] nutrient) {
		super();
		this.fcode = fcode;
		this.fname = fname;
		this.fmaker = fmaker;
		this.fmaterial = fmaterial;
		this.fimage = fimage;
		this.year = year;
		this.nutrient = nutrient;
	}
	public Food(int fcode, String fname, String fmaker, String fmaterial, String fimage, String year, String allergyList,
			float[] nutrient) {
		super();
		this.fcode = fcode;
		this.fname = fname;
		this.fmaker = fmaker;
		this.fmaterial = fmaterial;
		this.fimage = fimage;
		this.year = year;
		this.allergyList = allergyList;
		this.nutrient = nutrient;
	} 
	public Food() {
		super();
	}
	public int getFcode() {
		return fcode;
	}
	public void setFcode(int fcode) {
		this.fcode = fcode;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFmaker() {
		return fmaker;
	}
	public void setFmaker(String fmaker) {
		this.fmaker = fmaker;
	}
	public String getFmaterial() {
		return fmaterial;
	}
	public void setFmaterial(String fmaterial) {
		this.fmaterial = fmaterial;
	}
	public String getFimage() {
		return fimage;
	}
	public void setFimage(String fimage) {
		this.fimage = fimage;
	}
	public float[] getNutrient() {
		return nutrient;
	}
	public void setNutrient(float[] nutrient) {
		this.nutrient = nutrient;
	}

	@Override
	public String toString() {
		return "Food [fcode=" + fcode + ", fname=" + fname + ", fmaker=" + fmaker + ", fmaterial=" + fmaterial
				+ ", fimage=" + fimage + ", year=" + year + ", allergyList=" + allergyList + ", nutrient="
				+ Arrays.toString(nutrient) + "]";
	}
	
}
