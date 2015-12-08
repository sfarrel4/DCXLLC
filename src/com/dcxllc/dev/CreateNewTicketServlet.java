package com.dcxllc.dev;

import java.io.IOException;
import java.util.Properties;

import javax.jdo.PersistenceManager;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class CreateNewTicketServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doPost(req, resp);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String issueCategory = req.getParameter("ticketCategory");
		String issueDescription = req.getParameter("issueDescription");
		String dateIssued = req.getParameter("dateCreated");
		String companyName = req.getParameter("companyName");
		int ticketNumber = Integer.parseInt(req.getParameter("ticketNumber"));
		PersistenceManager pm = PMF.get().getPersistenceManager();
		OpenTicket o = new OpenTicket(issueCategory, issueDescription,dateIssued, companyName, ticketNumber);
		
		try{
			pm.makePersistent(o);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			pm.close();
		}
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		String htmlBody = "<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<title> </title>"
				+ "</head>"
				+ "<body>"
					+ "<h1>New Ticket Opened by:  "+ companyName + "</h1><br>"
					+ "<b>Type of Issue</b>: <u>"+ issueCategory + "</u><br><br>"
					+ "<b>Date of Ticket Issue</b>:" + dateIssued + " <br><br>"
					+ "<B>Summary of problem:</b> <br>"
					+ ""+ issueDescription +" "
					+ "<b>Ticket Number:</b>"
					+ "" +ticketNumber + ""
					+ "</body>"
					+ "</html>";
			Multipart mp = new MimeMultipart();

	        MimeBodyPart htmlPart = new MimeBodyPart();
	        
	    	try{
				Message msg = new MimeMessage(session);
				msg.setFrom(new InternetAddress("stephenfarrell3@gmail.com", "DCXLLC | Admin"));
				msg.addRecipient(Message.RecipientType.TO, 
						new InternetAddress("stephenfarrell3@gmail.com", "Admin"));
				msg.setSubject("New Ticket Created by: " + companyName);
				htmlPart.setContent(htmlBody, "text/html");
			    mp.addBodyPart(htmlPart);
			    msg.setContent(mp);
				Transport.send(msg);
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
		resp.sendRedirect("clientPage.jsp");
		
		
	}
}
