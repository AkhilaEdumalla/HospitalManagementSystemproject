package org.jsp.Hospital_Management_System.repository;

import java.util.List;
import java.util.Optional;


import org.jsp.Hospital_Management_System.dto.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository extends JpaRepository<Address,Integer> {
//   @Query("select a from Address a where a.pincode=?1")
//	public Optional<Address> verifypincode(int pincode);
//   
//    @Query("select a from Address a where a.city=?1")
//      public List<Address> findByCity(String city);
//    @Query("select a from Address a where a.state=?1")
//	 public List<Address> findByState(String state);
//
//    @Query("select a from Address a where a.country=?1")
//	 public List<Address> findByCountry(String country);

}
