package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
	private ArrayList<String> patientNotes;
	
	public Physician(int id){
		super(id);
	}
		
	public boolean assignPin(int pin) {
		if(Integer.toString(pin).length()!=4) {
			System.out.println("Pin must be four numbers.");
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
		return false;
		}
	}
		
	public void newPatientNotes(String notes, String patientName, Date date) {
		String report = String.format(
				"Datetime Submitted: %s \n", date);
	    report += String.format("Reported By ID: %s\n", this.id);
	    report += String.format("Patient Name: %s\n", patientName);
	    report += String.format("Notes: %s \n", notes);
	    this.patientNotes.add(report);
		
	}
    // TO DO: Setters & Getters

	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}




}
