package com.Userver.dto;

public class LoginResponseDto {
	
	
	private String message;
	public LoginResponseDto(String message, String token) {
		super();
		this.message = message;
		this.token = token;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private String token;
	
	public  LoginResponseDto() {
		// TODO Auto-generated constructor stub
	}

	public LoginResponseDto(String string) {
		// TODO Auto-generated constructor stub
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	

}
