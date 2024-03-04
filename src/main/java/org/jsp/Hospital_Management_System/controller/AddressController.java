package org.jsp.Hospital_Management_System.controller;

import java.util.List;

import org.jsp.Hospital_Management_System.dto.Address;
import org.jsp.Hospital_Management_System.dto.Branch;
import org.jsp.Hospital_Management_System.dto.ResponseStructure;
import org.jsp.Hospital_Management_System.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
 private AddressService service;
 @PostMapping("/addresss")
 public ResponseEntity<ResponseStructure<Address>> saveBranch(@RequestBody Address address)
 {
	return service.saveAddress(address);	
 }
 @PutMapping("/addresss")
 public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestBody Address address)
 {
	return service.updateAddress(address);	 
	
}
 @DeleteMapping("/addresss/{id}")
 public ResponseEntity<ResponseStructure<Address>> deleteBranch(@PathVariable(name="id") int id){
	  return service.deleteAddress(id);
 }
 @PostMapping("/addresss/{id}")
 public ResponseEntity<ResponseStructure<Address>> findBranchId(@PathVariable(name="id") int id)
 {
	 return service.findAddressId(id);
 }
// @PostMapping("/addresss/findbyCountry")
// public ResponseEntity<ResponseStructure<List<Address>>> findByCountry(@RequestParam String Country)
// {
//	 return service.findByCountry(Country);
// }
//@PostMapping("/addresss/findByCity")
// public ResponseEntity<ResponseStructure<List<Address>>> findByCity(@RequestParam String City)
// {
//	 return service.findByCity(City);
// }
//@PostMapping("/addresss/findByState")
//public ResponseEntity<ResponseStructure<List<Address>>> findByState(@RequestParam String state)
//{
//	 return service.findByState(state);
//}
//@PostMapping("/addresss/verifyByPincode")
//public ResponseEntity<ResponseStructure<Address>> verifyByPincode(@RequestParam int pincode)
//{
//	return service.verifyByPincode(pincode);
//}
}
