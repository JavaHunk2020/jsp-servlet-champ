package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/editProfile")
public class EditProfileServlet  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String pusername=req.getParameter("username");  //<a href="editProfile?username=${profileDTO.username}">
			try {
				   Class.forName("com.mysql.jdbc.Driver");
				   Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle_db","root","mysql@1234");
				   String sql="select username,password,name,email,qualification,mobile,photo,gender,createdate from user_login_tbl where username=?";
				   PreparedStatement pstmt=conn.prepareStatement(sql);
				   pstmt.setString(1,pusername);
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
					   ProfileDTO profileDTO=new ProfileDTO(username, password, name, email, mobile, gender, photo, qualification);
					   req.setAttribute("profileDTO", profileDTO);
					   //Going to edit jsp
					   req.getRequestDispatcher("esignup.jsp").forward(req, resp);
				  }
			}catch (Exception e) {
					e.printStackTrace();
			}
	}
}
