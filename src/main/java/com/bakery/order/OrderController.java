package com.bakery.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bakery.product.bo.ProductBO;
import com.bakery.product.entity.ProductEntity;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private ProductBO productBO;
	
	@RequestMapping("/order-create-view")
	public String orderCreateView(
			@RequestParam(value="productIdArray", required=false ) int[] productIdArray,
			Model model) {
		int[] array = productIdArray;
		List<ProductEntity> productList = productBO.selectByOrder(array);
		model.addAttribute("productList", productList);
		model.addAttribute("viewName", "/order/createOrder");
		return "template/bakeryLayout";
	}
}
