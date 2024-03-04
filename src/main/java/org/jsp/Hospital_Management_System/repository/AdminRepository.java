package org.jsp.Hospital_Management_System.repository;

import java.util.Optional;

import org.jsp.Hospital_Management_System.dto.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
   @Query("select a from Admin a where a.email=?1 and a.password=?2")
	 public Optional<Admin> verifyByEmail(String email, String password);
   
   
   @Query("select a from Admin a where a.phone=?1 and a.password=?2")
	 public Optional<Admin> verifyByPhone(long phone, String password);
   
}
