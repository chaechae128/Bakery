package com.bakery.order.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bakery.order.domain.OrderProduct;

@Mapper
public interface OrderProductMapper {
	
	public void insertOrderProduct(
			@Param("orderId")int orderId, 
			@Param("productId")int productId, 
			@Param("count")int count);
	
	public List<OrderProduct> selectOrderProductById (int orderId);
	
	public List<OrderProduct> selectOrderProduct();
}
