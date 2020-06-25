package com.servlet;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dto.ProfileDTO;

@WebServlet("/loggedUser")
public class LoggedUserServlet  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Set<ProfileDTO>  loggedUsers=ProfileDTO.loggedInUser();
		req.setAttribute("profileDTOs",loggedUsers);
 		req.getRequestDispatcher("loggedUsers.jsp").forward(req, resp);
	}
}
