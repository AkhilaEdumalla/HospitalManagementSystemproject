package org.jsp.Hospital_Management_System.controller;

import java.util.List;

import org.jsp.Hospital_Management_System.dto.Admin;
import org.jsp.Hospital_Management_System.dto.ResponseStructure;
import org.jsp.Hospital_Management_System.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

@RestController
public class AdminController { 
 @Autowired
	private AdminService service;
	@PostMapping("/admins")
 public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin)
 {
	return service.saveAdmin(admin); 
 }
	@PutMapping("/admins")
 public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@RequestBody Admin admin)
 {
	return service.updateAdmin(admin); 
 }
 @GetMapping("/admins/{id}")
 public ResponseEntity<ResponseStructure<Admin>> findById(@PathVariable(name= "id") int id){
	 return service.findById(id);
 }
  @DeleteMapping("admins/{id}")
 public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(@PathVariable(name= "id") int id){
	return service.deleteAdmin(id); 
 }
  @PostMapping("/admins/verifybyemail")
	 public ResponseEntity<ResponseStructure<Admin>> verifyByEmail(@RequestParam String email,@RequestParam  String password)
	 {
	   return service.verifyByEmail(email, password);	 
	 }
  @PostMapping("/admins/verifybyphone")
	 public ResponseEntity<ResponseStructure<Admin>> verifyByPhone(@RequestParam long phone,@RequestParam String password)
	 {
		return service.verifyByPhone(phone, password);
	 }
//	 @GetMapping("/admins")
//	 public ResponseEntity<ResponseStructure<List<Admin>>> findAllAdmin()
//	 {
//		return service.findAllAdmin();
// }
}
