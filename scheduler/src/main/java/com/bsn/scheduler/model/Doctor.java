package com.bsn.scheduler.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Doctor {
	
	@Id
	@GeneratedValue
	private Long id;
}
