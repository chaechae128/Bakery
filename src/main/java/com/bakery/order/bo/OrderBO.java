package com.bakery.order.bo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bakery.cart.bo.CartBO;
import com.bakery.order.domain.Order;
import com.bakery.order.mapper.OrderMapper;
import com.bakery.product.bo.ProductBO;
import com.bakery.product.entity.ProductEntity;

@Service
public class OrderBO {
	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private ProductBO productBO;
	
	@Autowired
	private OrderProductBO orderProductBO;
	
	@Autowired
	private CartBO cartBO;
	
	
	public void insertOrder(int userId, List<Map<String, Object>> list) {
		
		int productSellingPrice = (int) list.get(0).get("productPrice");
		int deliveryPrice = (int) list.get(0).get("deliveryPrice");
		String address = (String) list.get(0).get("address");
		String phoneNumber = (String) list.get(0).get("phoneNumber");
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("productSellingPrice", productSellingPrice);
		map.put("deliveryPrice", deliveryPrice);
		map.put("address", address);
		map.put("phoneNumber", phoneNumber);
		orderMapper.insertOrder(map);
		//방금 insert한 아이디
		int orderId = Integer.parseInt(map.get("id").toString());
		
		for(int i = 1; i< list.size(); i++) {
			String productName = (String) list.get(i).get("productName");
			ProductEntity product = productBO.selectByProductName(productName);
			int productId = product.getId();
			int count =  (int) list.get(i).get("count");
			orderProductBO.insertOrderProduct(orderId, productId, count);
			cartBO.deleteCartByUserIdProductId(userId, productId);
		}
	}
	
	
	public List<Order> selectOrder () {
		return orderMapper.selectOrder();
	}
	
	public void updateOrderStatus (int orderId, String status) {
		orderMapper.updateOrderStatus(orderId, status);
	}
	
	
}
