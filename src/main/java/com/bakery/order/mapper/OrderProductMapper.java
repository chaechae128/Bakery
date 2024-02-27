package com.bakery.order.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderProductMapper {
	
	public void insertOrderProduct(
			@Param("orderId")int orderId, 
			@Param("productId")int productId, 
			@Param("count")int count);
}
