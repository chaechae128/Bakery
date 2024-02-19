package com.bakery.cart.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CartMapper {
	public int insertCart(
			@Param("userId")int userId, 
			@Param("productId")int productId, 
			@Param("count")int count);
	
	
	public int selectCartByUserIdProductId(
			@Param("userId")int userId, 
			@Param("productId")int productId);
}
