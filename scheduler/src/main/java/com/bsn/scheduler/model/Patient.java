package com.bsn.scheduler.model;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Transient;

@Entity
public class Patient {
	
	@Transient
	Logger logger = LoggerFactory.getLogger(Patient.class);
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String firstName;
	private String lastName;
	
	@Embedded
	private Insurance insurance;
	
	@ManyToMany(mappedBy = "patients")
	Set<Doctor> doctors;
	
	public void addDoctor(Doctor doctor) {
		if (doctors == null) {
			doctors = new HashSet<>();
			logger.info("doctors list was empty, created new list in: " + this);
		}
		doctors.add(doctor);
		logger.info("Added doctor: " + doctor + " to patient: " + this);	
	}
	
	public void removeDoctor(Doctor doctor) {
		if (doctors.contains(doctor)) {
			doctors.remove(doctor);
			logger.info("Removed Doctor: " + doctor + " form Patient: " + this);
		} else {
			logger.info("Doctor: " + doctor + " not present in Patient: " + this);
		}
	}

	/**
	 * 
	 */
	public Patient() {
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
	 * @return the insurance
	 */
	public Insurance getInsurance() {
		return insurance;
	}

	/**
	 * @param insurance the insurance to set
	 */
	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	/**
	 * @return the doctors
	 */
	public Set<Doctor> getDoctors() {
		return doctors;
	}

	/**
	 * @param doctors the doctors to set
	 */
	public void setDoctors(Set<Doctor> doctors) {
		this.doctors = doctors;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}
