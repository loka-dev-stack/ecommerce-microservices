package com.payment_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment_service.dto.PaymentRequestDto;
import com.payment_service.dto.PaymentResponseDto;
import com.payment_service.service.PaymentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
	
	
	private final PaymentService paymentService;
	
	public PaymentController (PaymentService paymentService) {
		this.paymentService=paymentService;
	}
	
	@PostMapping
	public ResponseEntity<PaymentResponseDto> processPayment(@Valid @RequestBody 
			PaymentRequestDto requestDto){
		
		PaymentResponseDto responseDto = paymentService.processPayment(requestDto);
		
		return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{paymentId}")
	public ResponseEntity<PaymentResponseDto> getPaymentById(@PathVariable Long paymentId){
		return ResponseEntity.ok(paymentService.getPaymentById(paymentId));
		
	}
	
	@GetMapping
	public ResponseEntity<List<PaymentResponseDto>> getAllPayments(){
		return ResponseEntity.ok(paymentService.getAllPayments());
		
	}
	
	

}
