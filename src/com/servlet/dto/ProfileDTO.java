package com.servlet.dto;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;


@WebListener 
public class ProfileDTO implements HttpSessionBindingListener{
	private String username;
	private String password;
	private String name;
	private String email;
	private String mobile;
	private String gender;
	private String photo;
	private String qualification;
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfileDTO other = (ProfileDTO) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	private static Set<ProfileDTO> loggedInUsers=new HashSet<ProfileDTO>();
	
	
	public static Set<ProfileDTO> loggedInUser(){
		return loggedInUsers;
	}
	
	
	// session.setAttribute("userData", profileDTO);
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		ProfileDTO profileDTO=(ProfileDTO)event.getValue();
		loggedInUsers.add(profileDTO);
	}

	
	//session.removeAttribute("userData");
	//when session is invalidated
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		ProfileDTO profileDTO=(ProfileDTO)event.getValue();
		loggedInUsers.remove(profileDTO);// TODO Auto-generated method stub
	}

	public ProfileDTO() {
		
	}
	
	public ProfileDTO(String username, String password, String name, String email, String mobile, String gender,
			String photo, String qualification) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
		this.photo = photo;
		this.qualification = qualification;
	}

	private Timestamp createdate;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public Timestamp getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

}
