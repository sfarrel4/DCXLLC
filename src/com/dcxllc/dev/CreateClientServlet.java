package com.dcxllc.dev;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class CreateClientServlet  extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doPost(req, resp);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String companyName = req.getParameter("companyName");
		String companyAddress = req.getParameter("companyAddress");
		String mainEmail = req.getParameter("mainEmail");
		String secondaryEmail = req.getParameter("secondaryEmail");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		ClientAccount a = new ClientAccount(username, password, companyName, companyAddress, mainEmail, secondaryEmail);
		try{
			pm.makePersistent(a);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			pm.close();
		}
		
		resp.sendRedirect("adminPanel.jsp");
	}
}
