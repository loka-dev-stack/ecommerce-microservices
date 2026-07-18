package com.order_service.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order_service.dto.OrderRequestDto;
import com.order_service.dto.OrderResponseDto;
import com.order_service.entity.Orders;
import com.order_service.repository.OrdersRepository;
import com.order_service.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
    private OrdersRepository ordersrepo;

	private static final Logger logger =
            LoggerFactory.getLogger(OrderServiceImpl.class);
	
	private Orders mapToEntity(OrderRequestDto dto) {
		
		Orders orders = new Orders();
		orders.setUserId(dto.getUserId());;
		orders.setProductId(dto.getProductId());
		orders.setQuantity(dto.getQuantity());
		orders.setDeliveryAddress(dto.getDeliveryAddress());
		
		return orders;
	}
	
	private OrderResponseDto mapToResponse(Orders orders) {
		OrderResponseDto response = new OrderResponseDto();
		response.setOrderId(orders.getOrderId());
		 response.setUserId(orders.getUserId());
		    response.setProductId(orders.getProductId());
		    response.setQuantity(orders.getQuantity());
		    response.setPrice(orders.getPrice());
		    response.setTotalAmount(orders.getTotalAmount());
		    response.setOrderStatus(orders.getOrderStatus());
		    response.setPaymentStatus(orders.getPaymentStatus());
		    response.setOrderDate(orders.getOrderDate());
		    response.setDeliveryAddress(orders.getDeliveryAddress());
		return response;
		
	}

	@Override
	public OrderResponseDto createOrder(OrderRequestDto dto) {
		
		return null;
	}
	

}
