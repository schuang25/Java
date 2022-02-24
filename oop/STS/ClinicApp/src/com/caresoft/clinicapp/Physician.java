package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;
public class Physician extends User implements HIPAACompliantUser {
    
    // Inside class:    
    private ArrayList<String> patientNotes;
	
    // TO DO: Constructor that takes an ID
    // TO DO: Implement HIPAACompliantUser!
    
    public Physician(Integer id) {
    	super(id);
    	patientNotes = new ArrayList<String>();
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

	@Override
	public boolean assignPin(int pin) {
		if (pin > 9999 || pin < 1000)
			return false;
		this.pin = pin;
		return true;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// TODO Auto-generated method stub
		return this.id == confirmedAuthID;
	}

	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}

}
