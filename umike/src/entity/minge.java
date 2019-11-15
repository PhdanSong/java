package entity;

import java.io.Serializable;

public class minge implements Serializable{

	private String teacher_ID;
	private String count;
	public String getTeacher_ID() {
		return teacher_ID;
	}
	public void setTeacher_ID(String teacher_ID) {
		this.teacher_ID = teacher_ID;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
}
