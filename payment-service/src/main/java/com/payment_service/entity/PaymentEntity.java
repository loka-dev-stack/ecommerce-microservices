package com.payment_service.entity;

import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name="Payment_table")
public class PaymentEntity {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long paymentId;

	    @Column(nullable = false)
	    private Long orderId;

	    @Column(nullable = false)
	    private BigDecimal amount;

	    @Column(nullable = false)
	    private String paymentMethod;

	    @Column(nullable = false)
	    private String paymentStatus;

	    @Column(nullable = false, unique = true)
	    private String transactionId;

	    @Column(nullable = false)
	    private LocalDateTime paymentDate;
	    
	    public PaymentEntity() {
	    	
	    }

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
			return "PaymentEntity [paymentId=" + paymentId + ", orderId=" + orderId + ", amount=" + amount
					+ ", paymentMethod=" + paymentMethod + ", paymentStatus=" + paymentStatus + ", transactionId="
					+ transactionId + ", paymentDate=" + paymentDate + "]";
		}
	    
	    

}
