package com.Userver.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRequestDto {
	@NotBlank(message = "First Name is required")
	private String firstName;
	@NotBlank(message = "Last Name is required")
	private String lastName;
	
	@NotBlank(message = "Email is required")
	@Email(message="Invalid email")
	private String email;
	
	@Size(min = 6, message = "Password must be at least 6 characters")
	private String password ;
	
	private String role ;

	public String getFirstname() {
		return firstName;
	}

	public void setFirstname(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

}
