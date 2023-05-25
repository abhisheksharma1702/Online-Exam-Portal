package com.userManager.userManager.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "admin_login")
public class AdminLoginDetail {

	@Id
	@GenericGenerator(name="id" , strategy="increment")
	@GeneratedValue(generator="id")
	@Column(name="admin_id")
	private int id;
	@Column(length=100)
	private String email;
	@Column(length=100)
	private String password;
		
	public AdminLoginDetail() {
	}

	public AdminLoginDetail(int adminId, String emailId, String password) {
		this.id = adminId;
		this.email = emailId;
		this.password = password;
	}

	public int getAdminId() {
		return id;
	}

	public void setAdminId(int adminId) {
		this.id = adminId;
	}

	public String getEmailId() {
		return email;
	}

	public void setEmailId(String emailId) {
		this.email = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
