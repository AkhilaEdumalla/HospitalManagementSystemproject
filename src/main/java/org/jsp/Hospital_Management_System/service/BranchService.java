package org.jsp.Hospital_Management_System.service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.jsp.Hospital_Management_System.dao.BranchDao;
import org.jsp.Hospital_Management_System.dto.Branch;
import org.jsp.Hospital_Management_System.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
public class BranchService {
	@Autowired
private BranchDao branchdao;

 public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch b)
 {
	ResponseStructure<Branch> structure=new ResponseStructure<>();
	structure.setData(branchdao.saveBranch(b));
    structure.setMessage("Branch Saved");
    structure.setStatusCode(HttpStatus.CREATED.value());
    return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.CREATED);
	
 }
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(Branch branch)
	{
    ResponseStructure<Branch> structure=new ResponseStructure<>();
	Optional<Branch>recbranch=branchdao.findBranchid(branch.getId());
	if(recbranch.isPresent())
	{
		Branch dbBranch=recbranch.get();
		dbBranch.setName(branch.getName());
		dbBranch.setPhone(branch.getPhone());
		dbBranch.setEmail(branch.getEmail());
	 structure.setData(branchdao.saveBranch(branch));
	 structure.setMessage("updated Branch");
	 structure.setStatusCode(HttpStatus.ACCEPTED.value());
	 return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.ACCEPTED);
	}
	return null;
	}
	
 
  
  public ResponseEntity<ResponseStructure<Branch>> deleteBranch(int id)
  {
	  ResponseStructure<Boolean> structure=new ResponseStructure();
	  Optional<Branch> dbBranch=branchdao.findBranchid(id);
	  if(dbBranch.isPresent())
	  {
	  structure.setData(true);
	  structure.setMessage("deleted by id");
	  structure.setStatusCode(HttpStatus.OK.value());
	  branchdao.deletebranch(id);
	  return new ResponseEntity<ResponseStructure<Branch>>(HttpStatus.OK);
	  }
	return null;
  }
public ResponseEntity<ResponseStructure<Branch>> findBranchId(int id) {
	ResponseStructure<Branch> structure=new ResponseStructure<>();
	  Optional<Branch>dbBranch=branchdao.findBranchid(id);
	  structure.setData(dbBranch.get());
	  structure.setMessage("Find By Branch by id");
	  structure.setStatusCode(HttpStatus.OK.value());
	  return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.OK); 
}

public ResponseEntity<ResponseStructure<Branch>> verifyphone(long phone)
{
ResponseStructure<Branch> structure=new ResponseStructure<>();
Optional<Branch> recbranch=branchdao.verifyByPhone(phone);
if(recbranch.isPresent())
{
	structure.setData(recbranch.get());
	structure.setMessage("Verify by phone");
	structure.setStatusCode(HttpStatus.OK.value());
	return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.OK);
}
return null;
}
public ResponseEntity<ResponseStructure<Branch>> verifyEmail(String email)
{
	ResponseStructure<Branch> structure=new ResponseStructure<>();
	Optional<Branch> recbranch=branchdao.verifyEmail(email);
	if(recbranch.isPresent())
	{
		structure.setData(recbranch.get());
		structure.setMessage("Verify by email");
		structure.setStatusCode(HttpStatus.OK.value());
	return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.OK);
	}
	return null;
}
public ResponseEntity<ResponseStructure<List<Branch>>> findAllBranch()
{
	ResponseStructure<List<Branch>> structure=new ResponseStructure<>();
	structure.setData(branchdao.findAllBranch());
	structure.setMessage("Find All branch");
	structure.setStatusCode(HttpStatus.OK.value());
	return new ResponseEntity<ResponseStructure<List<Branch>>>(structure,HttpStatus.ACCEPTED);
}
}
 

