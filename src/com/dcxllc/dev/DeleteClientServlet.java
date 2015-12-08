package com.dcxllc.dev;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DeleteClientServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doPost(req, resp);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String[] clientIDs = req.getParameterValues("clientIDs");
		ClientAccount e = null;
		
		
			for(int i =0; i<clientIDs.length; i++){
				e = pm.getObjectById(ClientAccount.class,Long.valueOf(clientIDs[i]).longValue());
				pm.deletePersistent(e);
			}
			pm.close();
			resp.sendRedirect("adminPanel.jsp");
		
		
		
	}
}
