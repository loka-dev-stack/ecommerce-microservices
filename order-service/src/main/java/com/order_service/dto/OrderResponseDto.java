package com.order_service.dto;


import java.math.BigDecimal;
import java.time.LocalDateTime;


public class OrderResponseDto {

	  private Long orderId;

	    private Long userId;

	    private Long productId;

	    private Integer quantity;

	    private BigDecimal unitPrice;

	    private BigDecimal totalAmount;

	    private String orderStatus;

	    private String paymentStatus;

	    private LocalDateTime orderDate;

	    private String deliveryAddress;

		public Long getOrderId() {
			return orderId;
		}

		public void setOrderId(Long orderId) {
			this.orderId = orderId;
		}

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public Long getProductId() {
			return productId;
		}

		public void setProductId(Long productId) {
			this.productId = productId;
		}

		public Integer getQuantity() {
			return quantity;
		}

		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}

		public BigDecimal getunitPrice() {
			return unitPrice;
		}

		public void setunitPrice(BigDecimal unitPrice) {
			this.unitPrice = unitPrice;
		}

		public BigDecimal getTotalAmount() {
			return totalAmount;
		}

		public void setTotalAmount(BigDecimal totalAmount) {
			this.totalAmount = totalAmount;
		}

		public String getOrderStatus() {
			return orderStatus;
		}

		public void setOrderStatus(String orderStatus) {
			this.orderStatus = orderStatus;
		}

		public String getPaymentStatus() {
			return paymentStatus;
		}

		public void setPaymentStatus(String paymentStatus) {
			this.paymentStatus = paymentStatus;
		}

		public LocalDateTime getOrderDate() {
			return orderDate;
		}

		public void setOrderDate(LocalDateTime orderDate) {
			this.orderDate = orderDate;
		}

		public String getDeliveryAddress() {
			return deliveryAddress;
		}

		public void setDeliveryAddress(String deliveryAddress) {
			this.deliveryAddress = deliveryAddress;
		}

		@Override
		public String toString() {
			return "OrderResponseDto [orderId=" + orderId + ", userId=" + userId + ", productId=" + productId
					+ ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", totalAmount=" + totalAmount + ", orderStatus="
					+ orderStatus + ", paymentStatus=" + paymentStatus + ", orderDate=" + orderDate
					+ ", deliveryAddress=" + deliveryAddress + "]";
		}
	    public OrderResponseDto() {
	    	
	    }

}
