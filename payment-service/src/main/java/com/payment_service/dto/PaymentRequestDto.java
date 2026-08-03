package com.payment_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

public class PaymentRequestDto {
	
	@NotNull(message = "Order Id is required")
    private Long orderId;

    @NotBlank(message = "Payment Method is required")
    private String paymentMethod;
    
    public PaymentRequestDto() {
    	
    }

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Override
	public String toString() {
		return "PaymentRequestDto [orderId=" + orderId + ", paymentMethod=" + paymentMethod + "]";
	}
    
    

}
