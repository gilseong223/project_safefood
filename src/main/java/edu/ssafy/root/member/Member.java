package edu.ssafy.root.member;

import java.io.Serializable;

public class Member implements Serializable {

	private String ID;
	private String PW;
	private String name;
	private String address;
	private String phone;
	private Allergy allergy;
	private float[] nutri;
	
	public float[] getNutri() {
		return nutri;
	}

	public void setNutri(float[] nutri) {
		this.nutri = nutri;
	}

	@Override
	public String toString() {
		return "Member [ID=" + ID + ", PW=" + PW + ", name=" + name + ", address=" + address + ", phone=" + phone
				+ ", allergy=" + allergy + "]";
	}
	
	public Member(String id, float[] nutri) {
		this.ID = id;
		this.nutri = nutri;
	}
	
	public Member(String iD, String pW, String name, String address, String phone, Allergy allergy) {
		super();
		ID = iD;
		PW = pW;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.allergy = allergy;
	}
	
	
	
	public Member(String iD, String pW, String name, String address, String phone) {
		super();
		ID = iD;
		PW = pW;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public Member(String iD, String pW, String name, String address, String phone, Allergy allergy, float[] nutri) {
		super();
		ID = iD;
		PW = pW;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.allergy = allergy;
		this.nutri = nutri;
	}

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPW() {
		return PW;
	}
	public void setPW(String pW) {
		PW = pW;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Allergy getAllergy() {
		return allergy;
	}
	public void setAllergy(Allergy allergy) {
		this.allergy = allergy;
	}
}
