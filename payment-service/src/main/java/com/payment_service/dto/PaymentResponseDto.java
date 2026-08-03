package com.payment_service.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

public class PaymentResponseDto {
	
	  private Long paymentId;

	    private Long orderId;

	    private BigDecimal amount;

	    private String paymentMethod;

	    private String paymentStatus;

	    private String transactionId;

	    private LocalDateTime paymentDate;

		public Long getPaymentId() {
			return paymentId;
		}

		public void setPaymentId(Long paymentId) {
			this.paymentId = paymentId;
		}

		public Long getOrderId() {
			return orderId;
		}

		public void setOrderId(Long orderId) {
			this.orderId = orderId;
		}

		public BigDecimal getAmount() {
			return amount;
		}

		public void setAmount(BigDecimal amount) {
			this.amount = amount;
		}

		public String getPaymentMethod() {
			return paymentMethod;
		}

		public void setPaymentMethod(String paymentMethod) {
			this.paymentMethod = paymentMethod;
		}

		public String getPaymentStatus() {
			return paymentStatus;
		}

		public void setPaymentStatus(String paymentStatus) {
			this.paymentStatus = paymentStatus;
		}

		public String getTransactionId() {
			return transactionId;
		}

		public void setTransactionId(String transactionId) {
			this.transactionId = transactionId;
		}

		public LocalDateTime getPaymentDate() {
			return paymentDate;
		}

		public void setPaymentDate(LocalDateTime paymentDate) {
			this.paymentDate = paymentDate;
		}

		@Override
		public String toString() {
			return "PaymentResponseDto [paymentId=" + paymentId + ", orderId=" + orderId + ", amount=" + amount
					+ ", paymentMethod=" + paymentMethod + ", paymentStatus=" + paymentStatus + ", transactionId="
					+ transactionId + ", paymentDate=" + paymentDate + "]";
		}
	    
	    public PaymentResponseDto() {
	    	
	    }

}
