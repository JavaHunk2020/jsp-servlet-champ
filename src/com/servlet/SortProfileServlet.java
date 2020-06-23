package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.utils.DbUtils;

@WebServlet("/sortProfile")
public class SortProfileServlet  extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//I need to fetch whole profiles data from database
		String sort=req.getParameter("sort");
		List<ProfileDTO> profileDTOs=new ArrayList<>(); 
		try {
			  Connection conn=DbUtils.getConnection();
			  String sql="select username,password,name,email,qualification,mobile,photo,gender,createdate from user_login_tbl order by email "+sort;
			   PreparedStatement pstmt=conn.prepareStatement(sql);
			   //Fire the query
			   //CTR+SHIFT+O
			  ResultSet rs= pstmt.executeQuery();
			  while(rs.next()) { //here user is there
				   String username =rs.getString(1);
				   String password =rs.getString(2);
				   String name =rs.getString(3);
				   String email =rs.getString(4);
				   String qualification =rs.getString(5);
				   String mobile =rs.getString(6);
				   String photo =rs.getString(7);
				   String gender =rs.getString(8);
				   ProfileDTO profileDTO=new ProfileDTO(username, password, name, email, mobile, gender, photo, qualification);
				   profileDTOs.add(profileDTO);
			  }
		}catch (Exception e) {
				e.printStackTrace();
		}
		   //adding profileDTO object inside request scope with namemagic
		   req.setAttribute("profileDTOs", profileDTOs);
		   req.getRequestDispatcher("profiles.jsp").forward(req, resp);
	}	

}
