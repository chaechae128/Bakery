package com.bakery.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bakery.cart.domain.Cart;
import com.bakery.product.domain.Product;
import com.bakery.product.entity.ProductEntity;

@RequestMapping("/order")
@RestController
public class OrderRestController {
	@PostMapping("/create")
	public Map<String, Object> create(
			@RequestParam("userName") String userName,
			@RequestParam("productPrice") int productPrice,
			@RequestParam("deliveryPrice") int deliveryPrice,
			@RequestParam("address") String address,
			@RequestParam("phoneNumber") String phoneNumber,
			@RequestParam("productList") List<ProductEntity> productList
			//@RequestParam("cartList") List<Cart> cartList
			){
		
		//List<Map<String, Object>> orderList = cartList;
		List<ProductEntity> list = productList;
		
		Map<String, Object> result = new HashMap<>();
		

		return result;
	}
}

