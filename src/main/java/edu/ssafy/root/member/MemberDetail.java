package edu.ssafy.root.member;

import java.io.Serializable;

public class MemberDetail implements Serializable{
	int fcode;
	String mid;
	String date;
	int time;
	int cnt;
	
	public MemberDetail() {
	}
	public MemberDetail(int fcode, String mid, String date, int time, int cnt) {
		super();
		this.fcode = fcode;
		this.mid = mid;
		this.date = date;
		this.time = time;
		this.cnt = cnt;
	}
	
	public MemberDetail(int fcode, String mid, String date, int time) {
		super();
		this.fcode = fcode;
		this.mid = mid;
		this.date = date;
		this.time = time;
	}
	public int getFcode() {
		return fcode;
	}
	public void setFcode(int fcode) {
		this.fcode = fcode;
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
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MemberDetail [fcode=");
		builder.append(fcode);
		builder.append(", mid=");
		builder.append(mid);
		builder.append(", date=");
		builder.append(date);
		builder.append(", time=");
		builder.append(time);
		builder.append(", cnt=");
		builder.append(cnt);
		builder.append("]");
		return builder.toString();
	}
	
}
