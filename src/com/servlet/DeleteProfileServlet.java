package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteProfile")
public class DeleteProfileServlet  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String pusername=req.getParameter("username");
			
			try {
				   Class.forName("com.mysql.jdbc.Driver");
				   Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle_db","root","mysql@1234");
				   String sql="delete from user_login_tbl where username=?";
				   PreparedStatement pstmt=conn.prepareStatement(sql);
				   pstmt.setString(1, pusername);
				   pstmt.executeUpdate();
				   //Making call from servlet to servlet
				   req.getRequestDispatcher("profiles").forward(req, resp);
				   
			}catch (Exception e) {
					e.printStackTrace();
			}
	}

}
