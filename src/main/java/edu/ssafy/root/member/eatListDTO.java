package edu.ssafy.root.member;

import java.io.Serializable;

public class eatListDTO implements Serializable{
	int fcode;
	String mid;
	String date;
	String fname;
	int time;
	int cnt;

	public eatListDTO(int fcode, String mid, String date, String fname, int time, int cnt) {
		super();
		this.fcode = fcode;
		this.mid = mid;
		this.date = date;
		this.fname = fname;
		this.time = time;
		this.cnt = cnt;
	}

	public eatListDTO() {
		super();
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

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
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
		return "eatListDTO [fcode=" + fcode + ", mid=" + mid + ", date=" + date + ", fname=" + fname + ", time=" + time
				+ ", cnt=" + cnt + "]";
	}

}
