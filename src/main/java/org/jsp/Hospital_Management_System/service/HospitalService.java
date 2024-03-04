package org.jsp.Hospital_Management_System.service;

import java.util.Optional;

import org.jsp.Hospital_Management_System.dao.AdminDao;
import org.jsp.Hospital_Management_System.dao.HospitalDao;
import org.jsp.Hospital_Management_System.dto.Admin;
import org.jsp.Hospital_Management_System.dto.Hospital;
import org.jsp.Hospital_Management_System.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {
	@Autowired
	private HospitalDao hospitaldao;
	
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital)
	{
    ResponseStructure<Hospital> structure=new ResponseStructure<>();
    structure.setData(hospitaldao.saveHospital(hospital));
    structure.setMessage("Hospital is saved");
    structure.setStatusCode(HttpStatus.CREATED.value());
    return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(Hospital hospital)
	{
		ResponseStructure<Hospital> structure=new ResponseStructure<>();
		Optional<Hospital> recadmin=hospitaldao.findById(hospital.getHospital_id());
		if(recadmin.isPresent())
		{
		 Hospital hos=recadmin.get();
		 hos.setHospital_Established_date(hospital.getHospital_Established_date());
		 hos.setHospital_founder(hospital.getHospital_founder());
		 hos.setHospital_gstnumber(hospital.getHospital_gstnumber());
		 hos.setHospital_name(hospital.getHospital_name());
		 structure.setData(hospitaldao.saveHospital(hospital));
		 structure.setMessage("Hospital is Updated");
         structure.setStatusCode(HttpStatus.ACCEPTED.value());
          return new  ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.ACCEPTED);
		}
		return null;
	}
	public ResponseEntity<ResponseStructure<Hospital>> findById(int id)
	{
		ResponseStructure<Hospital> structure=new ResponseStructure<>();
		Optional<Hospital> recadmin=hospitaldao.findById(id);
		if(recadmin.isPresent())
		{
		structure.setData(recadmin.get());
		structure.setMessage("Find Hospital by id");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.OK);
		}
		return null;
		}
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(int id){
	   ResponseStructure<Boolean> structure=new ResponseStructure<>();
	   Optional<Hospital> recadmin=hospitaldao.findById(id);
	   if(recadmin.isPresent())
	   {
		  structure.setData(true);
		  structure.setMessage("delete the hospital by id");
		  structure.setStatusCode(HttpStatus.OK.value());
		  return new ResponseEntity<ResponseStructure<Hospital>>(HttpStatus.OK);
	   }
	   return null;
	}
	
}
