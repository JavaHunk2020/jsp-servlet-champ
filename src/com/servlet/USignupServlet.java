package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.utils.DbUtils;
import com.servlet.utils.Utils;

@WebServlet("/usignup")
public class USignupServlet  extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String qualification=req.getParameter("qualification");
		String mobile=req.getParameter("mobile");
		String gender=req.getParameter("gender");
		String photo=req.getParameter("photo");
		
		try {
			  Connection conn=DbUtils.getConnection();
			  String sql="update user_login_tbl set name=?,email=?,qualification=?,mobile=?,photo=?,gender=? where username=?";
			   PreparedStatement pstmt=conn.prepareStatement(sql);
			   pstmt.setString(1, name);
			   pstmt.setString(2, email);
			   pstmt.setString(3, qualification);
			   pstmt.setString(4, mobile);
			   pstmt.setString(5, photo);
			   pstmt.setString(6, gender);
			   pstmt.setString(7, username);
			   int iwiiwiw=pstmt.executeUpdate();
			   //This is making new request
			   resp.sendRedirect(req.getContextPath()+"/profiles");
		}catch (Exception e) {
				e.printStackTrace();
		}
	}

}
