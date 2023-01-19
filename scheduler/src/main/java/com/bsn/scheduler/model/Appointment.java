package com.bsn.scheduler.model;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Appointment {

	@Id
	@GeneratedValue
	private Long id;
	private Timestamp appointTime;
	private Boolean started, ended;
	private String reason;
	
	@ManyToOne
	private Doctor doctor;
	
	@ManyToOne
	private Patient patient;
	
	/**
	 * 
	 */
	public Appointment() {
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
	 * @return the appointTime
	 */
	public Timestamp getAppointTime() {
		return appointTime;
	}
	/**
	 * @param appointTime the appointTime to set
	 */
	public void setAppointTime(Timestamp appointTime) {
		this.appointTime = appointTime;
	}
	/**
	 * @return the started
	 */
	public Boolean getStarted() {
		return started;
	}
	/**
	 * @param started the started to set
	 */
	public void setStarted(Boolean started) {
		this.started = started;
	}
	/**
	 * @return the ended
	 */
	public Boolean getEnded() {
		return ended;
	}
	/**
	 * @param ended the ended to set
	 */
	public void setEnded(Boolean ended) {
		this.ended = ended;
	}
	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}
	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Override
	public String toString() {
		return "Appointment [id=" + id + ", appointTime=" + appointTime + ", started=" + started + ", ended=" + ended
				+ ", reason=" + reason + "]";
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
}
