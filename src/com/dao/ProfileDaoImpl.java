package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.servlet.ProfileDTO;
import com.servlet.utils.DbUtils;

public class ProfileDaoImpl {
	
	public ProfileDTO authUser(String pusername,String ppassword) {
		 ProfileDTO profileDTO=null;
		try {
		      Connection conn=DbUtils.getConnection();
			   String sql="select username,password,name,email,qualification,mobile,photo,gender,createdate from user_login_tbl where username=? and password=?";
			   PreparedStatement pstmt=conn.prepareStatement(sql);
			   pstmt.setString(1, pusername);
			   pstmt.setString(2, ppassword);
			   
			   //Fire the query
			   //CTR+SHIFT+O
			  ResultSet rs= pstmt.executeQuery();
			  if(rs.next()) { //here user is there
				   String username =rs.getString(1);
				   String password =rs.getString(2);
				   String name =rs.getString(3);
				   String email =rs.getString(4);
				   String qualification =rs.getString(5);
				   String mobile =rs.getString(6);
				   String photo =rs.getString(7);
				   String gender =rs.getString(8);
				    profileDTO=new ProfileDTO(username, password, name, email, mobile, gender, photo, qualification);
			  }	
		}catch (Exception e) {
				e.printStackTrace();
		}
		
		 return profileDTO;
		
	}

}
