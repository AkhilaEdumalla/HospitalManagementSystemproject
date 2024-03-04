package org.jsp.Hospital_Management_System.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Address {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		@Column(nullable=false)
		private String street,
		city,Landmark,Bulidingname,state,Country;
		@Column(nullable=false,unique = true)
		private int pincode;
			
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getStreet() {
			return street;
		}
		public void setStreet(String street) {
			this.street = street;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getLandmark() {
			return Landmark;
		}
		public void setLandmark(String landmark) {
			Landmark = landmark;
		}
		public String getBulidingname() {
			return Bulidingname;
		}
		public void setBulidingname(String bulidingname) {
			Bulidingname = bulidingname;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getCountry() {
			return Country;
		}
		public void setCountry(String country) {
			Country = country;
		}
		public int getPincode() {
			return pincode;
		}
		public void setPincode(int pincode) {
			this.pincode = pincode;
		}

	}



