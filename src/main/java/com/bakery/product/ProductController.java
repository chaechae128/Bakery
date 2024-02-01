package com.bakery.product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

	/**
	 * 상품 관리 화면
	 * @param model
	 * @return
	 */
	@GetMapping("/product-manage-view")
	public String productManageView(Model model) {
		model.addAttribute("viewName", "product/productManage");
		return "template/managerLayout";
	}
	
	/**
	 * 상품 등록 화면
	 * @param model
	 * @return
	 */
	@GetMapping("/product-add-view")
	public String productAddView(Model model) {
		model.addAttribute("viewName", "product/productAdd");
		return "template/managerLayout";
	}
}
