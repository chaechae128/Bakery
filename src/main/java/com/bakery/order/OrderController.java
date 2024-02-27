package com.bakery.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bakery.cart.bo.CartBO;
import com.bakery.cart.domain.Cart;
import com.bakery.product.bo.ProductBO;
import com.bakery.product.entity.ProductEntity;
import com.bakery.user.bo.UserBO;
import com.bakery.user.domain.User;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private ProductBO productBO;

	@Autowired
	private CartBO cartBO;
	
	@Autowired
	private UserBO userBO;


	/**
	 * 주문 하기 화면
	 * @param choice
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/order-create-view")
	public String orderCreateView(@RequestParam(value = "choice") List<Integer> choice, Model model, HttpSession session) {
		int userId = (int) session.getAttribute("userId");
		User user = userBO.selectByUserId(userId);
		model.addAttribute("user", user);
		
		List<Cart> cartList = cartBO.selectCarListByUserId(userId);
		model.addAttribute("cartList", cartList);
		
		List<ProductEntity> productList = productBO.selectByOrder(choice);
		//model.addAttribute("viewName", "/order/createOrder");
		model.addAttribute("viewName", "/order/testOrder");
		model.addAttribute("productList", productList);
		model.addAttribute("productCount", productList.size());
		return "template/bakeryLayout";
	}
	
	@RequestMapping("/order-complete-view")
	public String orderCompleteView(Model model) {
		model.addAttribute("viewName", "/order/completeOrder");
		return "template/bakeryLayout";
	}

}
