package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProfileDaoImpl;

@WebServlet("/auth")
public class AuthServlet  extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String pusername=req.getParameter("username");
			String ppassword=req.getParameter("password");
			ProfileDaoImpl profileDao=new ProfileDaoImpl();
			ProfileDTO profileDTO=profileDao.authUser(pusername, ppassword);
			if(profileDTO!=null) {
			   //adding profileDTO object inside request scope with namemagic
			   req.setAttribute("magic", profileDTO);
			   req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
		  }else {  //user is not there
			  req.setAttribute("hmmmm", "Sorry , username and password are not correct");
			  req.getRequestDispatcher("login.jsp").forward(req, resp);
		  }
	}
}
