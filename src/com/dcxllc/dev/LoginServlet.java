package com.dcxllc.dev;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doPost(req, resp);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			
			boolean authUser = false;
			
			List<AdminAccount> adminUsers = AdminAccount.getAllAdmin();
			List<EmployeeAccount> employeeUsers = EmployeeAccount.getAllEmployee();
			List<ClientAccount> clientUsers = ClientAccount.getAllClient();
			
			for(int i=0; i<adminUsers.size(); i++){
				if(username.equalsIgnoreCase(adminUsers.get(i).getUname()) && password.equals(adminUsers.get(i).getPword())){
					authUser = true;
					 Cookie loginCookie = new Cookie("username",username);
					 loginCookie.setMaxAge(30*60);
					 resp.addCookie(loginCookie);
					 resp.sendRedirect("adminPanel.jsp");
					
				}
			}
			
			for(int i=0; i<employeeUsers.size(); i++){
				if(username.equalsIgnoreCase(employeeUsers.get(i).getUsername()) && password.equals(employeeUsers.get(i).getPassword())){
					authUser = true;
					 Cookie loginCookie = new Cookie("username",username);
					 loginCookie.setMaxAge(30*60);
					 resp.addCookie(loginCookie);
					 resp.sendRedirect("employeePage.jsp");
					
				}
			}
			
			for(int i=0; i<clientUsers.size(); i++){
				if(username.equalsIgnoreCase(clientUsers.get(i).getUsername()) && password.equals(clientUsers.get(i).getPassword())){
					authUser = true;
					 Cookie loginCookie = new Cookie("username",username);
					 loginCookie.setMaxAge(30*60);
					 resp.addCookie(loginCookie);
					 resp.sendRedirect("clientPage.jsp");
					
				}
			}
			if(authUser){
				resp.sendRedirect("success.jsp");
			}
			else{
				resp.sendRedirect("failure.jsp");
			}
	}

}
