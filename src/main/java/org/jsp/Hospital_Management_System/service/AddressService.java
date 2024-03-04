package org.jsp.Hospital_Management_System.service;

import java.util.List;
import java.util.Optional;


import org.jsp.Hospital_Management_System.dao.AddressDao;
import org.jsp.Hospital_Management_System.dto.Address;
import org.jsp.Hospital_Management_System.dto.Branch;
import org.jsp.Hospital_Management_System.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
 @Autowired
	private AddressDao addressDao;
	
	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address)
	{
		
		ResponseStructure<Address> structure=new ResponseStructure<>();
		structure.setData(addressDao.saveAddress(address));
		structure.setMessage("Address saved");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return  new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.CREATED);
	}
	 
	public ResponseEntity<ResponseStructure<Address>> updateAddress(Address  address)
	{
		ResponseStructure<Address> structure=new ResponseStructure<>();
		Optional<Address> recAddress=addressDao.findById(address.getId());
		if(recAddress.isPresent())
		{
		 Address dbaddress=new Address();
		dbaddress.setLandmark(address.getLandmark());
		dbaddress.setCity(address.getCity());
		dbaddress.setBulidingname(address.getBulidingname());
		dbaddress.setCountry(address.getCountry());
		dbaddress.setPincode(address.getPincode());
		dbaddress.setState(address.getState());
		dbaddress.setStreet(address.getStreet());
		structure.setData(addressDao.saveAddress(dbaddress));
		structure.setMessage("Address updated");
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.ACCEPTED);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<Address>> findAddressId(int id)
	{
	ResponseStructure<Address> structure= new ResponseStructure<>();
	Optional<Address> recaddress=addressDao.findById(id);
	if(recaddress.isPresent())
	{
	 structure.setData(recaddress.get());
	 structure.setMessage("find by address with id");
	 structure.setStatusCode(HttpStatus.OK.value());
	 return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.OK);
	}
	return null;
	}
	 public ResponseEntity<ResponseStructure<Address>> deleteAddress(int id)
	 {
     ResponseStructure<Boolean> structure =new ResponseStructure<>();
     Optional<Address> recaddress=addressDao.findById(id);
     if(recaddress.isPresent())
     {
    structure.setData(true);
    structure.setMessage("address id deleted");
    structure.setStatusCode(HttpStatus.OK.value());
    addressDao.deleteById(id);
    return new ResponseEntity<ResponseStructure<Address>>(HttpStatus.OK);
	 }
     return null;
	}
//    public ResponseEntity<ResponseStructure<Address>> verifyByPincode(int pincode)
//    {
//    	ResponseStructure<Address> structure=new ResponseStructure<>();
//    	Optional<Address> recaddress=addressDao.verifypincode(pincode);
//    	if(recaddress.isPresent())
//    	{
//    		structure.setData(recaddress.get());
//    		structure.setMessage("Verify by Pincode");
//    		structure.setStatusCode(HttpStatus.OK.value());
//    		return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.OK);
//    	}
//    	return null;
//    }
//    public ResponseEntity<ResponseStructure<List<Address>>> findByCity(String city)
//    {
//    ResponseStructure<List<Address>> structure=new ResponseStructure<>();
//    structure.setData(addressDao.findAddressByCity(city));
//    structure.setMessage("find by city");
//    structure.setStatusCode(HttpStatus.OK.value());
//    return new ResponseEntity<ResponseStructure<List<Address>>>(structure,HttpStatus.ACCEPTED);
//    }
//    
//    public ResponseEntity<ResponseStructure<List<Address>>> findByState(String state)
//    {
//    ResponseStructure<List<Address>> structure=new ResponseStructure<>();
//    structure.setData(addressDao.findAddressByState(state));
//    structure.setMessage("find by state");
//    structure.setStatusCode(HttpStatus.OK.value());
//    return new ResponseEntity<ResponseStructure<List<Address>>>(structure,HttpStatus.ACCEPTED);
//    }
//    
//    public ResponseEntity<ResponseStructure<List<Address>>> findByCountry(String Country)
//    {
//    ResponseStructure<List<Address>> structure=new ResponseStructure<>();
//    structure.setData(addressDao.findAddressByCountry(Country));
//    structure.setMessage("find by country");
//    structure.setStatusCode(HttpStatus.OK.value());
//    return new ResponseEntity<ResponseStructure<List<Address>>>(structure,HttpStatus.ACCEPTED);
//    }
	}
	

