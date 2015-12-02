package com.dcxllc.dev;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class EmployeeAccount {
	
	@PrimaryKey
	    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	    private Long id;
	 
	 @Persistent
	 private String username;
	 
	 @Persistent
	 private String password;
	 
	 @Persistent
	 private String firstName;
	 
	 @Persistent
	 private String lastName;
	 
	 @Persistent
	 private String mainEmail;
	 
	 @Persistent
	 private String phoneNumber;
	 
	 

	 
	 
	 public EmployeeAccount(String username, String password, String firstName, String lastName,
			String mainEmail, String phoneNumber) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mainEmail = mainEmail;
		this.phoneNumber = phoneNumber;
	}


	public Long getId() {
		return id;
	}


	public String getUsername() {
		return username;
	}





	public void setUsername(String username) {
		this.username = username;
	}





	public String getPassword() {
		return password;
	}





	public void setPassword(String password) {
		this.password = password;
	}





	public String getFirstName() {
		return firstName;
	}





	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}





	public String getLastName() {
		return lastName;
	}





	public void setLastName(String lastName) {
		this.lastName = lastName;
	}





	public String getMainEmail() {
		return mainEmail;
	}





	public void setMainEmail(String mainEmail) {
		this.mainEmail = mainEmail;
	}





	public String getPhoneNumber() {
		return phoneNumber;
	}





	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}





	@SuppressWarnings("unchecked")
		public static List<EmployeeAccount> getAllEmployee(){
	    	PersistenceManager pm = PMF.get().getPersistenceManager();
			List<EmployeeAccount> results = null;
			try {
				Query q = pm.newQuery(EmployeeAccount.class);
				
				results = (List<EmployeeAccount>) q.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return results;
	    }

}
