package com.bsn.scheduler.repository;

import org.springframework.data.repository.CrudRepository;

import com.bsn.scheduler.model.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

}
