package edu.ssafy.root.service;

public class Meal {
	String mid;
	String date;
	int time;
	
	public Meal(String mid, String date, int time) {
		super();
		this.mid = mid;
		this.date = date;
		this.time = time;
	}
	public Meal() {
		super();
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Meal [mid=" + mid + ", date=" + date + ", time=" + time + "]";
	}
}
