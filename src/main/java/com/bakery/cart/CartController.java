package com.bakery.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bakery.cart.bo.CartBO;
import com.bakery.cart.domain.Cart;
import com.bakery.product.bo.ProductBO;
import com.bakery.product.entity.ProductEntity;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartBO cartBO;
	
	@Autowired
	private ProductBO productBO;
	
	/**
	 * 내 장바구니 목록 화면
	 * @param model
	 * @param session
	 * @return
	 */
	@GetMapping("/cart-list-view")
	public String productManageView(Model model
			,HttpSession session) {
		int userId = (int)session.getAttribute("userId");
		List<Cart> cartList = cartBO.selectCarListByUserId(userId);
		List<ProductEntity> productList = productBO.selectBycartList(cartList);
		model.addAttribute("userId", userId);
		model.addAttribute("cartList", cartList);
		model.addAttribute("productList", productList);
		model.addAttribute("viewName", "/myPage/cart");
		
		return "template/bakeryLayout";
	}
}
