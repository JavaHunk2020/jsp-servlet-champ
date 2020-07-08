package com.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/*")
public class AccessSecurityFilter implements Filter {

	private Set<String> allowedResources=new HashSet<String>(); 
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		allowedResources.add("/login.jsp");
		allowedResources.add("/auth");
		allowedResources.add("/fact");
		allowedResources.add("/error.jsp");
		allowedResources.add("/signup.jsp");
		allowedResources.add("/forgetPassword.jsp");
		allowedResources.add("/signup");
		allowedResources.add("/ajaxSearchProfile");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest =(HttpServletRequest)request;
		//http://localhost:8080/vehicle-store/profiles
		String resourcePath=httpServletRequest.getServletPath();
		if(allowedResources.contains(resourcePath) || resourcePath.contains("/img") || resourcePath.contains("htm")) {
			chain.doFilter(request,response);
		}else {
			
			  HttpSession session=httpServletRequest.getSession(false);
			  if(session!=null && session.getAttribute("userData")!=null) {
				  //ohhh user is logged in , let me go
				  chain.doFilter(request,response);
			  }else {
				  HttpServletResponse response2=(HttpServletResponse)response;
					//http://localhost:8080/vehicle-store
					response2.sendRedirect(httpServletRequest.getContextPath()+"/error.jsp");	  
			  }
		}
	}

	
	@Override
	public void destroy() {
		
	}
	 

}
