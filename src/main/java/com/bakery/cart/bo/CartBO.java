package com.bakery.cart.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bakery.cart.mapper.CartMapper;

@Service
public class CartBO {
	@Autowired
	private CartMapper cartMapper;
	
	
	public int insertCart(int userId, int productId, int count) {
		return cartMapper.insertCart(userId, productId, count);
	}
	
	public int selectCartByUserIdProductId(int userId, int productId) {
		return cartMapper.selectCartByUserIdProductId(userId, productId);
	}
	
}
