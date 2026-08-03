package com.payment_service.service;

import java.util.List;

import com.payment_service.dto.PaymentRequestDto;
import com.payment_service.dto.PaymentResponseDto;

public interface PaymentService {
  
    PaymentResponseDto processPayment(PaymentRequestDto requestDto);
    
    PaymentResponseDto getPaymentById(Long paymentId);

    List<PaymentResponseDto> getAllPayments();

}
