package com.bakery.order.bo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bakery.order.mapper.OrderMapper;

@Service
public class OrderBO {
	@Autowired
	private OrderMapper orderMapper;
	
	
	public int insertOrder(int userId, int productSellingPrice, int deliveryPrice, String address, String phoneNumber) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("productSellingPrice", productSellingPrice);
		map.put("deliveryPrice", deliveryPrice);
		map.put("address", address);
		map.put("phoneNumber", phoneNumber);
		orderMapper.insertOrder(map);
		int id = Integer.parseInt(map.get("id").toString());
		
		return id;
	}
}
