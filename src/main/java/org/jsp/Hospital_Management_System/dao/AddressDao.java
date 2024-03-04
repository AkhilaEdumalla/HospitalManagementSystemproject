package org.jsp.Hospital_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.Hospital_Management_System.dto.Address;
import org.jsp.Hospital_Management_System.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class AddressDao {
 @Autowired
	private AddressRepository addressRepository;
	
	public Address saveAddress(Address address)
	{
	  return addressRepository.save(address);
	}
	
	public Optional<Address> findById(int id)
	{
	return addressRepository.findById(id);
	}
	public Boolean deleteById(int id)
	{
		Optional<Address> recAddress=findById(id);
		if(recAddress.isPresent())
		{
        addressRepository.delete(recAddress.get());
        return true;
		}
		return false;
	}
	
//	public List<Address> findAddressByCity(String city)
//	{
//	return addressRepository.findByCity(city);  	
//	}
//	
//	public List<Address> findAddressByState(String state)
//	{
//		return addressRepository.findByState(state);
//	}
//	 
//	public List<Address> findAddressByCountry(String country)
//	{
//		return addressRepository.findByCountry(country);
//	}
//
//	public Optional<Address> verifypincode(int pincode)
//	{
//		return addressRepository.verifypincode(pincode);
//
//	}
	
}
