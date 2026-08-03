package com.payment_service.serviceimpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment_service.client.OrderClient;
import com.payment_service.dto.OrderResponseDto;
import com.payment_service.dto.PaymentRequestDto;
import com.payment_service.dto.PaymentResponseDto;
import com.payment_service.entity.PaymentEntity;
import com.payment_service.exception.PaymentNotFoundException;
import com.payment_service.repository.PaymentRepository;
import com.payment_service.service.PaymentService;

import jakarta.transaction.Transactional;
@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private PaymentRepository paymentRepo;
	@Autowired
	private OrderClient orderClient;
	
	

	@Override
	@Transactional
	public PaymentResponseDto processPayment(PaymentRequestDto requestDto) {
		OrderResponseDto orderById = orderClient.getOrderById(requestDto.getOrderId());
		if (orderById == null) {
		    throw new PaymentNotFoundException("Order not found");
		}
		PaymentEntity entity = mapToEntity(requestDto, orderById);
		PaymentEntity save = paymentRepo.save(entity);
		
		return mapToResponse(save);
	}
	
	private PaymentEntity mapToEntity(PaymentRequestDto dto,OrderResponseDto order) {
		PaymentEntity payment = new PaymentEntity();

	    payment.setOrderId(order.getOrderId());
	    payment.setAmount(order.getTotalAmount());
	    payment.setPaymentMethod(dto.getPaymentMethod());
	    payment.setPaymentStatus("SUCCESS");
	    payment.setTransactionId(UUID.randomUUID().toString());
	    payment.setPaymentDate(LocalDateTime.now());
		return payment;
		
	}
	
	private PaymentResponseDto mapToResponse(PaymentEntity payment) {
		PaymentResponseDto dto = new PaymentResponseDto();

	    dto.setPaymentId(payment.getPaymentId());
	    dto.setOrderId(payment.getOrderId());
	    dto.setAmount(payment.getAmount());
	    dto.setPaymentMethod(payment.getPaymentMethod());
	    dto.setPaymentStatus(payment.getPaymentStatus());
	    dto.setTransactionId(payment.getTransactionId());
	    dto.setPaymentDate(payment.getPaymentDate());

	    return dto;
	}

	@Override
	public PaymentResponseDto getPaymentById(Long paymentId) {
		PaymentEntity entity = paymentRepo.findById(paymentId).orElseThrow(()->
		new PaymentNotFoundException("PaymentId Not Found :"+paymentId));
		return mapToResponse(entity);
	}

	@Override
	public List<PaymentResponseDto> getAllPayments() {
		List<PaymentResponseDto> list = paymentRepo.findAll().stream().map(this::mapToResponse).toList();
		return list;
	}
	
	

}
