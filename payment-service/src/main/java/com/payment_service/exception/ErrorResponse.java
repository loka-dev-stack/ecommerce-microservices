package com.payment_service.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
	
	private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ErrorResponse [timestamp=" + timestamp + ", status=" + status + ", error=" + error + ", message="
				+ message + "]";
	}
    
    public ErrorResponse() {
    	
    }

}
