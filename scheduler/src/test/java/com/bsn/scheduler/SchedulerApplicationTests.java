package com.bsn.scheduler;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.bsn.scheduler.model.Doctor;
import com.bsn.scheduler.model.Insurance;
import com.bsn.scheduler.model.Patient;
import com.bsn.scheduler.repository.DoctorRepository;
import com.bsn.scheduler.repository.PatientRepository;
import com.github.javafaker.Faker;

import jakarta.persistence.Transient;

@SpringBootTest
class SchedulerApplicationTests {
	
	Logger logger = LoggerFactory.getLogger(SchedulerApplicationTests.class);

	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testInsertPatient() {
		logger.info("Start testInsertPatient()");
		Faker faker = new Faker();
		
		Insurance insurance = new Insurance();
		insurance.setProviderName(faker.company().name());
		insurance.setCoPay(faker.number().randomDouble(2, 0, 1));
		
		Patient patient = new Patient();
		patient.setFirstName(faker.name().firstName());
		patient.setLastName(faker.name().lastName());
		patient.setInsurance(insurance);
		patientRepository.save(patient);
		logger.info("End testInsertPatient()");
	}//Done working
	
	@Test
	public void testInsertDoctor() {
		logger.info("Start testInsertDoctor()");
		Faker faker = new Faker();
				
		Doctor doctor = new Doctor();
		doctor.setFirstName(faker.name().firstName());
		doctor.setLastName(faker.name().lastName());
		doctor.setSpeciality(faker.medical().diseaseName());
		doctor.setStartYear(faker.number().numberBetween(1985, 2020));
	
		doctorRepository.save(doctor);
		logger.info("End testInsertDoctor()");
	}//Done working

	@Test
	public void testDoctorPatientLinking() {
		logger.info("Start testDoctorPatientLinking()");
		Patient patient = patientRepository.findById(52L).get();
		Doctor doctor = doctorRepository.findById(102L).get();
		doctor.addPatient(patient);
//		patient.addDoctor(doctor);
		doctorRepository.save(doctor);
//		patientRepository.save(patient);
		logger.info("End testDoctorPatientLinking()");
	}//Done working
}
