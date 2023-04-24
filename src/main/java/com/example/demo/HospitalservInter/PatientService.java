package com.example.demo.HospitalservInter;

import java.util.List;

import com.example.demo.model.Patient;

public interface PatientService {

	Patient savePatient(Patient patient);
	List<Patient> getAllPatient(String name);
	Patient  getPatientById(int patientId);
	 Patient updatePatientDetails(Patient newVal, int patientId);
	 void deletePatientById(int patientId);
	 void deleteAllPatient();
	
}