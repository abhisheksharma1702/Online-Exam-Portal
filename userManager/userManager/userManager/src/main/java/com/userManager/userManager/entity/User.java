package com.userManager.userManager.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
public class User implements UserDetails {

	@Id
	@GenericGenerator(name="id" , strategy="increment")
	@GeneratedValue(generator="id")
	private int user_id;
	@Column(length=70)
	private String full_name;
	@Column(length=40)
	private String email;
	@Column(length=500)
	private String password;
	@Column(length=13)
	private String mobile;
	@Column(length=30)
	private String city;
	@Column(length=30)
	private String state;
	@Column
	private Date date_of_birth;
	@Column(length=25)
	private String qualification;
	@Column
	private int year_of_completion;

	public User() {
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return this.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public int getYear_of_completion() {
		return year_of_completion;
	}

	public void setYear_of_completion(int year_of_completion) {
		this.year_of_completion = year_of_completion;
	}

	@Override
	public String toString() {
		return "UserDetails [user_id=" + user_id + ", full_name=" + full_name + ", email=" + email + ", password="
				+ password + ", mobile=" + mobile + ", city=" + city + ", state=" + state + ", date_of_birth="
				+ date_of_birth + ", qualification=" + qualification + ", year_of_completion=" + year_of_completion
				+ "]";
	}
	
	

}
