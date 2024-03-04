package org.jsp.Hospital_Management_System.dao;

import java.util.Optional;

import org.jsp.Hospital_Management_System.dto.Hospital;
import org.jsp.Hospital_Management_System.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HospitalDao {
	@Autowired
	private HospitalRepository hospitalrepository;

	public Hospital saveHospital(Hospital hospital) {
		return hospitalrepository.save(hospital);
	}


	public boolean deleteById(int id) {
		Optional<Hospital> rechospital= findById(id);
		if(rechospital.isPresent()) {
			hospitalrepository.delete(rechospital.get());
			return true;
		}
		return false;
	}



	public Optional<Hospital> findById(int id) {
		return hospitalrepository.findById(id);
	}

}
