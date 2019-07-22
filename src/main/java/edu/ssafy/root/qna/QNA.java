package edu.ssafy.root.qna;

import java.io.Serializable;

public class QNA implements Serializable{
	private int seq;
	private String mid;
	private String category;
	private String title;
	private String question;
	private String answer;
	private String time;
	
	
	public QNA() {
		super();
	}
	public QNA(int seq, String mid, String category, String title, String question, String answer, String time) {
		super();
		this.seq = seq;
		this.mid = mid;
		this.category = category;
		this.title = title;
		this.question = question;
		this.answer = answer;
		this.time = time;
	}
	public QNA(String mid, String category, String title, String question) {
		super();
		this.mid = mid;
		this.category = category;
		this.title = title;
		this.question = question;
	}
	public QNA(String mid, String category, String title, String question, String answer) {
		super();
		this.mid = mid;
		this.category = category;
		this.title = title;
		this.question = question;
		this.answer = answer;
	}
	public QNA(String mid, String category, String title, String question, String answer, String time) {
		super();
		this.mid = mid;
		this.category = category;
		this.title = title;
		this.question = question;
		this.answer = answer;
		this.time = time;
	}
	public QNA(int seq, String mid, String category, String title, String question) {
		super();
		this.seq = seq;
		this.mid = mid;
		this.category = category;
		this.title = title;
		this.question = question;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "QNA [seq=" + seq + ", mid=" + mid + ", category=" + category + ", title=" + title + ", question="
				+ question + ", answer=" + answer + ", time=" + time + "]";
	}
	
}
