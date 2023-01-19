package com.bsn.scheduler.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class Doctor {
	
	@Transient
	Logger logger = LoggerFactory.getLogger(Doctor.class);
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String firstName;
	private String lastName;
	private String speciality;
	
	private Integer startYear;
	
	@OneToMany
	List<Appointment> appointments;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinTable(
			name = "doctors_patients",
			joinColumns = @JoinColumn(name = "doctor_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id")
	)
	Set<Patient> patients;
	
	public void addPatient(Patient patient) {
		if (patients == null) {
			patients = new HashSet<>();
			logger.info("patients list was empty, created new list in: " + this);
		}
		patients.add(patient);
		logger.info("Added Patient: " + patient + " to Doctor: " + this);	
	}
	
	public void removePatient(Patient patient) {
		if (patients.contains(patient)) {
			patients.remove(patient);
			logger.info("Removed Patient: " + patient + " form Doctor: " + this);
		} else {
			logger.info("Patient: " + patient + " not present in Doctor: " + this);
		}
	}

	/**
	 * 
	 */
	public Doctor() {
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the speciality
	 */
	public String getSpeciality() {
		return speciality;
	}

	/**
	 * @param speciality the speciality to set
	 */
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	/**
	 * @return the startYear
	 */
	public Integer getStartYear() {
		return startYear;
	}

	/**
	 * @param startYear the startYear to set
	 */
	public void setStartYear(Integer startYear) {
		this.startYear = startYear;
	}

	/**
	 * @return the patients
	 */
	public Set<Patient> getPatients() {
		return patients;
	}

	/**
	 * @param patients the patients to set
	 */
	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", speciality=" + speciality
				+ ", startYear=" + startYear + "]";
	}
}
