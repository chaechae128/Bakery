package com.bakery.order.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bakery.order.domain.OrderProduct;
import com.bakery.order.mapper.OrderProductMapper;

@Service
public class OrderProductBO {
	@Autowired
	private OrderProductMapper orderProductMapper;
	
	public void insertOrderProduct(int orderId, int productId, int count) {
		orderProductMapper.insertOrderProduct(orderId, productId, count);
	}
	
	public List<OrderProduct> selectOrderProductById (int orderId) {
		return orderProductMapper.selectOrderProductById(orderId);
	}
	
	public List<OrderProduct> selectOrderProduct () {
		return orderProductMapper.selectOrderProduct();
	}
	
}
