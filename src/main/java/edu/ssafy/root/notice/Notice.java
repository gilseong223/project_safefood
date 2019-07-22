package edu.ssafy.root.notice;

import java.io.Serializable;

public class Notice implements Serializable {

	private String seq;
	private String mid;
	private String title;
	private String contents;
	private String time;
	public Notice(String seq, String mid, String title, String contents, String time) {
		super();
		this.seq = seq;
		this.mid = mid;
		this.title = title;
		this.contents = contents;
		this.time = time;
	}
	public Notice(String mid, String title, String contents) {
		super();
		this.mid = mid;
		this.title = title;
		this.contents = contents;
	}
	
	public Notice(String seq, String mid, String title, String contents) {
		super();
		this.seq = seq;
		this.mid = mid;
		this.title = title;
		this.contents = contents;
	}
	public Notice() {
		super();
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Notice [seq=" + seq + ", mid=" + mid + ", title=" + title + ", contents=" + contents + ", time=" + time
				+ "]";
	}
	
	
}
