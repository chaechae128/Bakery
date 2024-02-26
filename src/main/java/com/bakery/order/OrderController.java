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

//	@RequestMapping("/order-create-view")
//	public String orderCreateView(@RequestParam(value = "productIdArray", required = false) String[] productIdArray,
//			Model model, HttpSession session) {
//		int userId = (int) session.getAttribute("userId");
//		List<Cart> cartList = cartBO.selectCarListByUserId(userId);
//		model.addAttribute("cartList", cartList);
//
//		if (productIdArray != null) {
//			int[] array = new int[productIdArray.length];
//			for (int i = 0; i < productIdArray.length; i++) {
//				array[i] = Integer.parseInt(productIdArray[i]);
//			}
//			List<ProductEntity> productList = productBO.selectByOrder(array);
//			model.addAttribute("productList", productList);
//		}
//
//		model.addAttribute("viewName", "/order/createOrder");
//		return "template/bakeryLayout";
//	}

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

}
