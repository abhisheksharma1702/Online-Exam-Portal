package com.userManager.userManager.entity;


import com.userManager.userManager.dto.ReportCompKey;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Entity
@Component
@IdClass(ReportCompKey.class)
public class Reports implements Serializable {


	@Id
	@Column(name="user_id")
	int user_id;
	@Id
	int course_id;
	private int level_1;
	private int level_2;
	private int level_3;
	public Reports() {
	}

	public Reports(int user_id, int course_id, int level_1, int level_2, int level_3) {
		this.user_id = user_id;
		this.course_id = course_id;
		this.level_1 = level_1;
		this.level_2 = level_2;
		this.level_3 = level_3;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public int getLevel_1() {
		return level_1;
	}

	public void setLevel_1(int level_1) {
		this.level_1 = level_1;
	}

	public int getLevel_2() {
		return level_2;
	}

	public void setLevel_2(int level_2) {
		this.level_2 = level_2;
	}

	public int getLevel_3() {
		return level_3;
	}

	public void setLevel_3(int level_3) {
		this.level_3 = level_3;
	}

}
