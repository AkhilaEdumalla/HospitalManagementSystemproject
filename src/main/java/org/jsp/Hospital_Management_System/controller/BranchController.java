package org.jsp.Hospital_Management_System.controller;

import java.util.List;

import org.jsp.Hospital_Management_System.dto.Branch;
import org.jsp.Hospital_Management_System.dto.ResponseStructure;
import org.jsp.Hospital_Management_System.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BranchController {
	@Autowired
 private BranchService service;
 @PostMapping("/branchs")
 public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch)
 {
	return service.saveBranch(branch);	
 }
 @PutMapping("/branchs")
 public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestBody Branch branch)
 {
	return service.updateBranch(branch);	 
	
}
 @DeleteMapping("/branchs/{id}")
 public ResponseEntity<ResponseStructure<Branch>> deleteBranch(@PathVariable(name="id") int id){
	  return service.deleteBranch(id);
 }
 @GetMapping("/branchs/{id}")
 public ResponseEntity<ResponseStructure<Branch>> findBranchId(@PathVariable(name="id") int id)
 {
	 return service.findBranchId(id);
 }
 @PostMapping("/branchs/verifyByPhone")
 public ResponseEntity<ResponseStructure<Branch>> verifyByPhone(@RequestParam long phone)
 {
	 return service.verifyphone(phone);
 }
 @PostMapping("/branchs/verifyByPhone")
 public ResponseEntity<ResponseStructure<Branch>> verifyByEmail(@RequestParam String email)
 {
	 return service.verifyEmail(email);
 }
 @GetMapping("/branchs")
 public ResponseEntity<ResponseStructure<List<Branch>>> findBranchAll()
 {
	 return service.findAllBranch();
 }
}
