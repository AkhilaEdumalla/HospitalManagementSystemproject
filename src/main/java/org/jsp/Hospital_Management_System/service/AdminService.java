package org.jsp.Hospital_Management_System.service;


import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.jsp.Hospital_Management_System.dao.AdminDao;
import org.jsp.Hospital_Management_System.dto.Admin;
import org.jsp.Hospital_Management_System.dto.ResponseStructure;
import org.slf4j.helpers.Reporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
	@Autowired
	private AdminDao admindao;
	
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin)
	{
    ResponseStructure<Admin> structure=new ResponseStructure<>();
    structure.setData(admindao.saveAdmin(admin));
    structure.setMessage("Admin is saved");
    structure.setStatusCode(HttpStatus.CREATED.value());
    return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin admin)
	{
		ResponseStructure<Admin> structure=new ResponseStructure<>();
		Optional<Admin> recadmin=admindao.findByAdmin(admin.getId());
		if(recadmin.isPresent())
		{
		 Admin ad=recadmin.get();
		 ad.setName(admin.getName());
		 ad.setEmail(admin.getEmail());
		 ad.setPhone(admin.getPhone());
		 ad.setPassword(admin.getPassword());
		 structure.setData(admindao.saveAdmin(admin));
		 structure.setMessage("Admin is Updated");
         structure.setStatusCode(HttpStatus.ACCEPTED.value());
          return new  ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.ACCEPTED);
		}
		return null;
	}
	public ResponseEntity<ResponseStructure<Admin>> findById(int id)
	{
		ResponseStructure<Admin> structure=new ResponseStructure<>();
		Optional<Admin> recadmin=admindao.findByAdmin(id);
		if(recadmin.isPresent())
		{
		structure.setData(recadmin.get());
		structure.setMessage("Find admin by id");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);
		}
		return null;
		}
	public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(int id){
	   ResponseStructure<Boolean> structure=new ResponseStructure<>();
	   Optional<Admin> recadmin=admindao.findByAdmin(id);
	   if(recadmin.isPresent())
	   {
		  structure.setData(true);
		  structure.setMessage("delete the admin by id");
		  structure.setStatusCode(HttpStatus.OK.value());
		  return new ResponseEntity<ResponseStructure<Admin>>(HttpStatus.OK);
	   }
	   return null;
	}
	 public ResponseEntity<ResponseStructure<Admin>> verifyByEmail(String email,String password)
	 {
		ResponseStructure< Admin> structure=new ResponseStructure<>();
		Optional<Admin> recadmin=admindao.verifyByEmail(email, password);
		if(recadmin.isPresent())
		{
		 structure.setData(recadmin.get());
		 structure.setMessage("Admin is verified by email");
		 structure.setStatusCode(HttpStatus.OK.value());
		 return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);
		}
		return null;
	 }
	
	 
	 public ResponseEntity<ResponseStructure<Admin>> verifyByPhone(long phone,String password)
	 {
		ResponseStructure< Admin> structure=new ResponseStructure<>();
		Optional<Admin> recadmin=admindao.verifyByPhone(phone,password);
		if(recadmin.isPresent())
		{
		 structure.setData(recadmin.get());
		 structure.setMessage("Admin is verified by phone");
		 structure.setStatusCode(HttpStatus.OK.value());
		 return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);
		}
		return null;
	 }
	 public ResponseEntity<ResponseStructure<List<Admin>>> findAllAdmin()
	 {
		ResponseStructure<List<Admin>> structure=new ResponseStructure<>();
		structure.setData(admindao.findAll());
		structure.setMessage("All admins are found");
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return  new ResponseEntity<ResponseStructure<List<Admin>>>(structure,HttpStatus.ACCEPTED);	
	 }
}
