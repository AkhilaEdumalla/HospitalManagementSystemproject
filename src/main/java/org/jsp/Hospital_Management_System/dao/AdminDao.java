package org.jsp.Hospital_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.Hospital_Management_System.dto.Admin;
import org.jsp.Hospital_Management_System.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao {
@Autowired
	private AdminRepository adminrepository;
	
public Admin saveAdmin(Admin admin)
{
	 return adminrepository.save(admin);	
}
 public Optional<Admin> findByAdmin(int id)
 {
	 return adminrepository.findById(id);
 }
 public boolean deleteByAdmin(int id)
 {
	 Optional<Admin> recadmin=adminrepository.findById(id);
	 if(recadmin.isPresent())
	 {
	  adminrepository.delete(recadmin.get());
	  return true;
	 }
	return false;
 }
 public Optional<Admin> verifyByEmail(String email,String password)
 {
	 return adminrepository.verifyByEmail(email,password);
 }
 public Optional<Admin> verifyByPhone(long phone,String password)
 {
	 return adminrepository.verifyByPhone(phone,password);
 }
public List<Admin> findAll()
{
return adminrepository.findAll();	
}
}
