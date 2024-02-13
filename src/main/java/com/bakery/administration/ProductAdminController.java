package com.bakery.administration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bakery.administration.bo.ProductAdminBO;
import com.bakery.product.domain.Product;

@Controller
@RequestMapping("/product")
public class ProductAdminController {
	@Autowired
	private ProductAdminBO productBO;

	/**
	 * 상품 관리 화면
	 * @param model
	 * @return
	 */
	@GetMapping("/product-manage-view")
	public String productManageView(Model model) {
		List<Product> productList = productBO.selectProduct();
		model.addAttribute("productList", productList);
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
	
	
	@GetMapping("/product-update-view")
	public String productUpdateView(Model model,
			@RequestParam("productId") int productId) {
		//db select
		Product product = productBO.selectProductById(productId);
		model.addAttribute("product", product);
		model.addAttribute("viewName", "product/productUpdate");
		return "template/managerLayout";
	}
	
	
}
