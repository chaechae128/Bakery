package com.bakery.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bakery.product.bo.ProductBO;
import com.bakery.product.entity.ProductEntity;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductBO productBO;
	
	@GetMapping("/product-list")
	public String productList(
			@RequestParam("menu") String menu,
			Model model){
		List<ProductEntity> productList = productBO.selectByMenu(menu);
		model.addAttribute("productList", productList);
		
		model.addAttribute("viewName", "/product/productList");
		return "template/bakeryLayout";
	}
}
