package com.bakery.cart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bakery.cart.domain.Cart;

@Mapper
public interface CartMapper {
	public int insertCart(
			@Param("userId")int userId, 
			@Param("productId")int productId, 
			@Param("count")int count);
	
	
	public int selectCartByUserIdProductId(
			@Param("userId")int userId, 
			@Param("productId")int productId);
	
	public List<Cart> selectCarListByUserId(int userId);
	
	public int deleteCartByUserIdProductId(
			@Param("userId")int userId, 
			@Param("productId")int productId);
	
	public void deleteListByUserId(int userId);
}
