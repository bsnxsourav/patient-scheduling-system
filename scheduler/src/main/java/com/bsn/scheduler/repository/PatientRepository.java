package com.bsn.scheduler.repository;

import org.springframework.data.repository.CrudRepository;

import com.bsn.scheduler.model.Patient;

public interface PatientRepository extends CrudRepository<Patient, Long> {

}
