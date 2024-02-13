package com.bakery.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bakery.product.bo.ProductBO;
import com.bakery.product.domain.Product;

@RestController
@RequestMapping("/product")
public class ProductRestController {
	@Autowired
	private ProductBO productBO;
	
	@RequestMapping("/product-list")
	public Map<String, Object> productList(
			@RequestParam("menu") String menu){
		if (menu.equals("All")) {
			List<Product> productList = productBO.selectAll();
			
		}
		Map<String, Object> result = new HashMap<>();
		return result;
	}
	
}
