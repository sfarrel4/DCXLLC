package com.dcxllc.dev;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class OpenTicket {
	
	 @PrimaryKey
	    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long ticketID;
	 
	 @Persistent
	private String issueCategory;
	 @Persistent
	private String issueDescription;
	 @Persistent
	private String dateIssued;
	 @Persistent
	private String companyName;
	 @Persistent
	private String comments ="";
	 @Persistent
	private int ticketNumber = 111;
	 
	 public OpenTicket(String issueCategory, String issueDescription, String dateIssued, String companyName, int ticketNumber){
		 this.issueCategory = issueCategory;
		 this.issueDescription = issueDescription;
		 this.dateIssued = dateIssued;
		 this.companyName = companyName;
		 this.ticketNumber= ticketNumber;
		  
		 
	 }

	public Long getTicketID() {
		return ticketID;
	}

	public String getIssueCategory() {
		return issueCategory;
	}

	public String getIssueDescription() {
		return issueDescription;
	}

	public String getDateIssued() {
		return dateIssued;
	}

	public String getComments() {
		return comments;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setIssueCategory(String issueCategory) {
		this.issueCategory = issueCategory;
	}

	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}

	public  void setComments(String comments) {
		this.comments = comments;
	}
	public String getCompanyName(){
		return companyName;
	}
	
	@SuppressWarnings("unchecked")
	public static List<OpenTicket> getAllOpenTickets(){
    	PersistenceManager pm = PMF.get().getPersistenceManager();
		List<OpenTicket> results = null;
		try {
			Query q = pm.newQuery(OpenTicket.class);
			q.setOrdering("ticketNumber ascending");
			
			results = (List<OpenTicket>) q.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return results;
    }

}
