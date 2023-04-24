package com.example.demo.service;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.demo.HospitalservInter.PatientService;
import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService{
	PatientRepository patientRepository;
	public PatientServiceImpl(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}
		
	public Patient savePatient(Patient patient) {
		return patientRepository.save(patient);
	}

@Override
public List<Patient>  getAllPatient(String name) {
	return patientRepository.findAll();
}

	@Override
	public Patient  getPatientById(int patientId) {
		Optional<Patient> patient = patientRepository.findById(patientId);
		if(patient.isPresent()) {
			return patient.get();
		}
		else {
			return null;
		}
	}

	@Override
	public Patient updatePatientDetails(Patient newVal, int patientId) {
		Optional<Patient>patient = patientRepository.findById(patientId);
		if(patient.isPresent()) {
			Patient existingPatient = patient.get();  //'2', 'mny@123', 'abc', 'xyz'

			existingPatient.setFirstName(newVal.getFirstName());
			existingPatient.setLastName(newVal.getLastName());
			existingPatient.setBirthdate(newVal.getBirthdate());
			existingPatient.setGender(newVal.getGender());
			existingPatient.setEmailID(newVal.getEmailID());
			existingPatient.setMobileNo(newVal.getMobileNo());
			existingPatient.setAdharNo(newVal.getAdharNo());
			existingPatient.setBloodGroup(newVal.getBloodGroup());
			patientRepository.save(existingPatient);
			return existingPatient;
		}
		else {
			return null;
		}
	}

	@Override
	public void deletePatientById(int patientId) {
		Optional<Patient> patient = patientRepository.findById(patientId);
		if(patient.isPresent()) {
			patientRepository.deleteById(patientId);
		}	
	}
	
	@Override
	public void deleteAllPatient() {
	 patientRepository.deleteAll();
	}
	
	
}
	