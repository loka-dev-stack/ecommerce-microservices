package com.Userver.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
		
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
    private Long userId;
	@NotBlank(message = "First Name is required")
	@Column(nullable = false, length = 100)
    private String firstName;
	@NotBlank(message = "Last Name is required")
	@Column(nullable = false, length = 100)
    private String lastName;

	@Email(message = "Invalid Email")
	@NotBlank(message = "Email is required")
	@Column(nullable = false, unique = true, length = 255)
    private String email;
	@Size(min = 8, message = "Password must be at least 8 characters")
	@Column(nullable = false, length = 255)
    private String password;

    private String role;
    
    public User(){
    	
    }

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", role=" + role + "]";
	}
    

	
}
