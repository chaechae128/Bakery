package com.bakery.order.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bakery.order.mapper.OrderProductMapper;

@Service
public class OrderProductBO {
	@Autowired
	private OrderProductMapper orderProductMapper;
	
	public void insertOrderProduct(int orderId, int productId, int count) {
		orderProductMapper.insertOrderProduct(orderId, productId, count);
	}
}
