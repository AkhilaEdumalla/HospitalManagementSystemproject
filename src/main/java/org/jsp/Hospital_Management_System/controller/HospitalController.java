package org.jsp.Hospital_Management_System.controller;

import org.jsp.Hospital_Management_System.dto.Hospital;
import org.jsp.Hospital_Management_System.dto.ResponseStructure;
import org.jsp.Hospital_Management_System.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class HospitalController {
	@Autowired
	private HospitalService service;
	@PostMapping("/hospitals")
 public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody Hospital hospital)
 {
	return service.saveHospital(hospital);
 }
	@PutMapping("/hospitals")
 public ResponseEntity<ResponseStructure<Hospital>> updateHospital(@RequestBody Hospital hospital)
 {
	return service.updateHospital(hospital); 
 }
 @PostMapping("/hospitals/{id}")
 public ResponseEntity<ResponseStructure<Hospital>> findHospitalById(@PathVariable(name= "id") int id){
	 return service.findById(id);
 }
  @DeleteMapping("hospitals/{id}")
 public ResponseEntity<ResponseStructure<Hospital>> deleteHospitalById(@PathVariable(name= "id") int id){
	return service.deleteHospital(id);
 }

}
