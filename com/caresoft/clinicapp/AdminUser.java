package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
	private Integer employeeID;
	private String role;
	private ArrayList<String> securityIncidents;

	public AdminUser(int id) {
		super(id);
		this.employeeID = id;
		this.role = "";
		this.securityIncidents = new ArrayList<String>();
	}
	public AdminUser(int id, String role) {
		super(id);
		this.employeeID = id;
		this.role = role;
		this.securityIncidents = new ArrayList<String>();
	}

	public boolean assignPin(int pin) {
		if(Integer.toString(pin).length()!=6) {
			System.out.println("Pin must be six numbers.");
			return false;
		} else {
			this.setPin(pin);
			return true;
		}
	}

	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(confirmedAuthID == this.id) {
			return true;
		} else {
			authIncident();
			return false;
		}
	}
	
	public ArrayList<String> reportSecurityIncidents() {
		return securityIncidents;
	}
    
 
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }

    //Setters & Getters
	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


    
    


}
