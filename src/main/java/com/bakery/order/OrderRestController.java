package com.bakery.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bakery.order.bo.OrderBO;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/order")
@RestController
public class OrderRestController {
	@Autowired
	private OrderBO orderBO;
	
	@PostMapping("/create")
	public Map<String, Object> create(
			@RequestBody List<Map<String, Object>> list,
			HttpSession session
			){
		
		//order db insert
		int userId = (int)session.getAttribute("userId");
		int productSellingPrice = (int) list.get(0).get("productPrice");
		int deliveryPrice = (int) list.get(0).get("deliveryPrice");
		String address = (String) list.get(0).get("address");
		String phoneNumber = (String) list.get(0).get("phoneNumber");
		
		//방금 insert한 id
		int id = orderBO.insertOrder(userId, productSellingPrice, deliveryPrice, address, phoneNumber);
		
		
		//방금 insert한 행의 id값을 가져와서 order_product db에 저장
		Map<String, Object> result = new HashMap<>();
		

		return result;
	}
}
