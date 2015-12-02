package com.dcxllc.dev;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SuppressWarnings("serial")
public class CreateAdminServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doPost(req, resp);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		AdminAccount a = new AdminAccount(username, password);
		try{
			pm.makePersistent(a);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			pm.close();
		}
	}
}
