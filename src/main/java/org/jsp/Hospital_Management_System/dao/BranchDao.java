package org.jsp.Hospital_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.Hospital_Management_System.dto.Branch;
import org.jsp.Hospital_Management_System.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BranchDao {
	@Autowired
 private BranchRepository branchrepository;
 
 public Branch saveBranch(Branch b) {
		return branchrepository.save(b);
	}

 
 public boolean deletebranch(int id)
 {
	 Optional<Branch> recbranch=findBranchid(id);
	 if(recbranch.isPresent())
	 {
        branchrepository.delete(recbranch.get());
        return true;
	 }
	return false;
 }

public Optional<Branch> findBranchid(int id) {
	 return branchrepository.findById(id);
}
public Optional<Branch> verifyByPhone(long phone)
{
 return branchrepository.verifyphone(phone);
}
public Optional<Branch> verifyEmail(String email)
{
	return branchrepository.verifyEmail(email);
}
public List<Branch> findAllBranch()
{
	return branchrepository.findAll();
}
}
