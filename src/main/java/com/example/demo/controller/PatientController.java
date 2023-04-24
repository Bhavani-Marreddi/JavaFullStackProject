package com.example.demo.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;
import com.example.demo.service.PatientServiceImpl;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class PatientController {

	@Autowired
	public PatientServiceImpl patientService;
	public PatientController(PatientServiceImpl patientService) {
		this.patientService = patientService;
	}
	@Autowired
	PatientRepository patientRepository;
//	public PatientController(PatientRepository patientRepository) {
//		this.patientRepository = patientRepository;
//	}
	

	@PostMapping("/patients")
	public ResponseEntity<Patient> savePatient(@RequestBody Patient patient){
		try {
			return new ResponseEntity<>( patientService.savePatient(patient), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}	
		}
	
	@PutMapping("/patients/{patientId}")
	public ResponseEntity<Patient> updatePatientDetailsById(@PathVariable("patientId") int id,
			@RequestBody Patient patient){
		return new ResponseEntity<Patient>(patientService.updatePatientDetails(patient, id), HttpStatus.OK);
		
	}
	
	@GetMapping("/patients")
	public ResponseEntity<List<Patient>> getAllPatient(@RequestParam(required = false) String name){
		try {
			List<Patient> patientList = new ArrayList<Patient>();
			if(name !=null) {
				patientRepository.findByFirstNameContaining(name).forEach(patientList::add);
				return new ResponseEntity<>(patientList,HttpStatus.OK);
			}else {
                 patientList=patientRepository.findAll();
				return new ResponseEntity<>(patientList,HttpStatus.OK);
			}
	}
		catch(Exception e) {
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/patients/{id}")
	public ResponseEntity<Patient>  getPatientById(@PathVariable("id")  int patientId){
		return new ResponseEntity<Patient>(patientService.getPatientById(patientId), HttpStatus.OK);
	}
	
	@DeleteMapping("/patients/{id}")
	public ResponseEntity<String> deletePatientById(@PathVariable("id")  int patientId){
		patientService.deletePatientById(patientId);
		return new ResponseEntity<String>("deleted successfully", HttpStatus.OK);
	}
	 
	@DeleteMapping("/patients")
	public ResponseEntity<HttpStatus> deleteAllPatient(){
		try {
		       patientRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}

	
	@GetMapping("/patients/fetchByBloodGroup1")
	public ResponseEntity<List<Patient>> findBybloodGroup1() {
		try {
			List<Patient> PatientbloodGroupList = patientRepository.findBybloodGroup("A+");

			if (PatientbloodGroupList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(PatientbloodGroupList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/patients/fetchByBloodGroup2")
	public ResponseEntity<List<Patient>> findBybloodGroup2() {
		try {
			List<Patient> PatientbloodGroupList = patientRepository.findBybloodGroup("A-");

			if (PatientbloodGroupList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(PatientbloodGroupList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/patients/fetchByBloodGroup3")
	public ResponseEntity<List<Patient>> findBybloodGroup3() {
		try {
			List<Patient> PatientbloodGroupList = patientRepository.findBybloodGroup("B+");

			if (PatientbloodGroupList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(PatientbloodGroupList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/patients/fetchByBloodGroup4")
	public ResponseEntity<List<Patient>> findBybloodGroup4() {
		try {
			List<Patient> PatientbloodGroupList = patientRepository.findBybloodGroup("B-");

			if (PatientbloodGroupList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(PatientbloodGroupList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/patients/fetchByBloodGroup5")
	public ResponseEntity<List<Patient>> findBybloodGroup5() {
		try {
			List<Patient> PatientbloodGroupList = patientRepository.findBybloodGroup("O+");

			if (PatientbloodGroupList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(PatientbloodGroupList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/patients/fetchByBloodGroup6")
	public ResponseEntity<List<Patient>> findBybloodGroup6() {
		try {
			List<Patient> PatientbloodGroupList = patientRepository.findBybloodGroup("O-");

			if (PatientbloodGroupList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(PatientbloodGroupList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/patients/fetchByBloodGroup7")
	public ResponseEntity<List<Patient>> findBybloodGroup7() {
		try {
			List<Patient> PatientbloodGroupList = patientRepository.findBybloodGroup("AB+");

			if (PatientbloodGroupList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(PatientbloodGroupList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/patients/fetchByBloodGroup8")
	public ResponseEntity<List<Patient>> findBybloodGroup8() {
		try {
			List<Patient> PatientbloodGroupList = patientRepository.findBybloodGroup("AB-");

			if (PatientbloodGroupList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(PatientbloodGroupList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
