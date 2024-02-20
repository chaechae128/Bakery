package com.bakery.cart.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bakery.cart.domain.Cart;
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
	
	public List<Cart> selectCarListByUserId(int userId) {
		return cartMapper.selectCarListByUserId(userId);
	}
	
	public int deleteCartByUserIdProductId(int userId, int productId) {
		return cartMapper.deleteCartByUserIdProductId(userId, productId);
	}
	
}
