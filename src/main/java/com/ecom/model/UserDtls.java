package com.ecom.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class UserDtls {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	private String name;
	
	private String mobileNumber;
	
	private String email;
	
	private String address;
	
	private String city;
	 
	private String state;
	
	private String pinCode;
	
	private String password;
	
	private String profileImage;
	
	private String role;
	
	private Boolean isEnable;
	
	private Boolean accountNonLocked;
	
	private Integer failledAtempt; 
	
	private Date lockTime;
	
	private String resetToken;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(Boolean isEnable) {
		this.isEnable = isEnable;
	}

	public Boolean getAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(Boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public Integer getFailledAtempt() {
		return failledAtempt;
	}

	public void setFaillAtempt(Integer faillAtempt) {
		this.failledAtempt = faillAtempt;
	}

	public Date getLockTime() {
		return lockTime;
	}

	public void setLockTime(Date lockTime) {
		this.lockTime = lockTime;
	}

	public String getResetToken() {
		return resetToken;
	}

	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}

	public UserDtls(Integer id, String name, String mobileNumber, String email, String address, String city,
			String state, String pinCode, String password, String profileImage, String role, Boolean isEnable,
			Boolean accountNonLocked, Integer failledAtempt, Date lockTime, String resetToken) {
		super();
		Id = id;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
		this.password = password;
		this.profileImage = profileImage;
		this.role = role;
		this.isEnable = isEnable;
		this.accountNonLocked = accountNonLocked;
		this.failledAtempt = failledAtempt;
		this.lockTime = lockTime;
		this.resetToken = resetToken;
	}

	public UserDtls() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	

	
	
}
