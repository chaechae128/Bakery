package com.bakery.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bakery.order.bo.OrderBO;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/order")
@RestController
public class OrderRestController {
	@Autowired
	private OrderBO orderBO;
	
	/**
	 * 주문서 작성
	 * @param list
	 * @param session
	 * @return
	 */
	@PostMapping("/create")
	public Map<String, Object> create(
			@RequestBody List<Map<String, Object>> list,
			HttpSession session
			){
		
		//order db insert
		int userId = (int)session.getAttribute("userId");
		orderBO.insertOrder(userId, list);
		
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", "성공");
		result.put("code", "200");
		
		return result;
	}
	
	/**
	 * 주문 현황 수정 API
	 * @param orderId
	 * @param status
	 * @return
	 */
	@PostMapping("/order-update-status")
	public Map<String, Object> updateStatus(
			@RequestParam("orderId") int orderId,
			@RequestParam("status") String status) {
		
		orderBO.updateOrderStatus(orderId, status);
		
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", "성공");
		result.put("code", "200");
		
		return result;
	}
}
