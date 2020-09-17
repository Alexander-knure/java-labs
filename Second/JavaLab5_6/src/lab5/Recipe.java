package lab5;

import java.util.Date;

public class Recipe {

	private Doctor doctor;
	private Patient patient;
	private Institution institution;
	private Date registrationDate;
////////////////////////////////
	private String purpose;
	private Date expirationDate;
////////////////////////////////
	public Recipe(Doctor doctor, Patient patient, Institution institution, Date registrationDate, String purpose, Date expirationDate)
	{
		this.doctor = doctor;
		this.patient = patient;
		this.institution = institution;
		this.registrationDate = registrationDate;
////////////////////////////////
		this.purpose  = purpose;
		this.expirationDate = expirationDate;
////////////////////////////////
	}
	
	public Date getRegistrationDate() {
		return registrationDate;
	}

	public Institution getInstitution() {
		return institution;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	////////////////////////////////////////////
	public String getPurpose() {
		return purpose;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}
	////////////////////////////////////////////

}
