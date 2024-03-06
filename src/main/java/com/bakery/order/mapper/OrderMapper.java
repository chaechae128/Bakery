package com.bakery.order.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bakery.order.domain.Order;

@Mapper
public interface OrderMapper {
	public int insertOrder(Map<String, Object> map);
	
	public List<Order> selectOrder ();
	
	public void updateOrderStatus (
			@Param("orderId")int orderId, 
			@Param("status")String status);
	
	public List<Order> selectOrderByUserId(int userId);
	
}
