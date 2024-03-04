package org.jsp.Hospital_Management_System.repository;

import java.util.Optional;

import org.jsp.Hospital_Management_System.dto.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BranchRepository extends JpaRepository<Branch, Integer>
{
  @Query("select b from Branch b where b.phone=?1")
	Optional<Branch> verifyphone(long phone);
 @Query("select b from Branch b where b.email=?1")
   Optional<Branch> verifyEmail(String email);
  
 

}
