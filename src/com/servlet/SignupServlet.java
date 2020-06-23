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

@WebServlet("/signup")
public class SignupServlet  extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String qualification=req.getParameter("qualification");
		String mobile=req.getParameter("mobile");
		String gender=req.getParameter("gender");
		String photo=req.getParameter("photo");
		String password =Utils.generateRandomPassword(5);
		String usenname=email;
		
		try {
			  Connection conn=DbUtils.getConnection();
			 String sql="insert into  user_login_tbl(username,password,name,email,qualification,mobile,photo,gender,createdate) values(?,?,?,?,?,?,?,?,?)";
			   PreparedStatement pstmt=conn.prepareStatement(sql);
			   pstmt.setString(1, usenname);
			   pstmt.setString(2, password);
			   pstmt.setString(3, name);
			   pstmt.setString(4, email);
			   pstmt.setString(5, qualification);
			   pstmt.setString(6, mobile);
			   pstmt.setString(7, photo);
			   pstmt.setString(8, gender);
			   Timestamp createdate=new Timestamp(new Date().getTime());
			   pstmt.setTimestamp(9, createdate);
			   int iwiiwiw=pstmt.executeUpdate();
			   System.out.println("Rows inserted = "+iwiiwiw);
			   req.setAttribute("hmmmm", "Hi , "+name+" , you have done signup successfully!!!!!!!!!!!");
			  req.getRequestDispatcher("login.jsp").forward(req, resp);
		}catch (Exception e) {
				e.printStackTrace();
		}
	}

}
