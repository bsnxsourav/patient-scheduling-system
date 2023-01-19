package com.bsn.scheduler.repository;

import org.springframework.data.repository.CrudRepository;

import com.bsn.scheduler.model.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {

}
