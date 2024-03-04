package org.jsp.Hospital_Management_System.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hospital_id;
	@Column(nullable = false)
	private String hospital_name;
	@Column(nullable = false)
	private String hospital_founder;
	@Column(nullable = false,unique = true)
	private String hospital_gstnumber;
	@Column(nullable = false)
	private LocalDate hospital_Established_date;
	public int getHospital_id() {
		return hospital_id;
	}
	public void setHospital_id(int hospital_id) {
		this.hospital_id = hospital_id;
	}
	public String getHospital_name() {
		return hospital_name;
	}
	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}
	public String getHospital_founder() {
		return hospital_founder;
	}
	public void setHospital_founder(String hospital_founder) {
		this.hospital_founder = hospital_founder;
	}
	public String getHospital_gstnumber() {
		return hospital_gstnumber;
	}
	public void setHospital_gstnumber(String hospital_gstnumber) {
		this.hospital_gstnumber = hospital_gstnumber;
	}
	public LocalDate getHospital_Established_date() {
		return hospital_Established_date;
	}
	public void setHospital_Established_date(LocalDate hospital_Established_date) {
		this.hospital_Established_date = hospital_Established_date;
	}

	
}
