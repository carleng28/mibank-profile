package com.miBank.profileservice.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Carlos Gomez
 * 
 */
@Entity
@Table(name = "Profile")
public class Profile implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "profile_id", updatable = false, nullable = false)
	@JsonProperty("id")
	@NotNull
	private int profileId;

	@Column(name = "first_name", columnDefinition = "VARCHAR(50)", nullable = false)
	@JsonProperty("first_name")
	@NotNull
	private String firstName;

	@Column(name = "last_name", columnDefinition = "VARCHAR(50)", nullable = false)
	@JsonProperty("last_name")
	@NotNull
	private String lastName;

	@Column(name = "address", columnDefinition = "VARCHAR(200)", nullable = false)
	@JsonProperty("address")
	@NotNull
	private String address;

	@Column(name = "city", columnDefinition = "VARCHAR(50)", nullable = false)
	@JsonProperty("city")
	@NotNull
	private String city;

	@Column(name = "province", columnDefinition = "VARCHAR(50)", nullable = false)
	@JsonProperty("province")
	@NotNull
	private String province;

	@Column(name = "postal_code", columnDefinition = "VARCHAR(10)", nullable = false)
	@JsonProperty("postal_code")
	@NotNull
	private String postalCode;

	@Column(name = "country", columnDefinition = "VARCHAR(50)", nullable = false)
	@JsonProperty("country")
	@NotNull
	private String country;

	@Column(name = "email", columnDefinition = "VARCHAR(100)", nullable = false)
	@JsonProperty("email")
	@NotNull
	private String email;

	@Column(name = "phone_number", columnDefinition = "VARCHAR(20)", nullable = true)
	@JsonProperty("phone_number")
	private String phoneNumber;

	@Column(name = "picture_url", nullable = true)
	@JsonProperty("picture")
	private String pictureUrl;

	
	public Profile() {}
	
	public Profile(@NotNull int profileId, @NotNull String firstName, @NotNull String lastName, @NotNull String address,
			@NotNull String city, @NotNull String province, @NotNull String postalCode, @NotNull String country,
			@NotNull String email, String phoneNumber, String pictureUrl) {
		super();
		this.profileId = profileId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
		this.country = country;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.pictureUrl = pictureUrl;
	}



	public int getProfileId() {
		return profileId;
	}



	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getProvince() {
		return province;
	}



	public void setProvince(String province) {
		this.province = province;
	}



	public String getPostalCode() {
		return postalCode;
	}



	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getPictureUrl() {
		return pictureUrl;
	}



	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + ", city=" + city + ", province=" + province + ", postalCode=" + postalCode + ", country="
				+ country + ", email=" + email + ", phoneNumber=" + phoneNumber + ", picture_url=" + pictureUrl + "]";
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) {
			return false;}
		Profile other = (Profile) obj;
		if (this.profileId != other.getProfileId()) {
			return false;
		}
		return true;
	}

}