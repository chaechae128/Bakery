package com.bakery.cart;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bakery.cart.bo.CartBO;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/cart")
public class CartRestController {
	@Autowired
	private CartBO cartBO;

	@RequestMapping("cart-in")
	public Map<String, Object> cartIn(@RequestParam("productId") int productId, @RequestParam("count") int count,
			HttpSession session) {
		Map<String, Object> result = new HashMap<>();
		Integer userId = (Integer) session.getAttribute("userId");
		// 로그인 되어있는지 확인
		if (userId == null) {
			result.put("code", 300);
			result.put("error_message", "로그인이 되어있지 않습니다. 로그인 후 이용해주세요");
			return result;
		}
		// 이미 장바구니에 있는지 확인
		if (cartBO.selectCartByUserIdProductId(userId, productId) > 0) {
			result.put("code", 500);
			result.put("error_message", "이미 장바구니에 담긴 상품입니다.");
			return result;
		}

		if (cartBO.insertCart(userId, productId, count) > 0) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "실패");
		}

		return result;
	}

	@DeleteMapping("/cart-out")
	public Map<String, Object> delete(@RequestParam("productId") int productId, HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		// db delete
		int count = cartBO.deleteCartByUserIdProductId(userId, productId);

		// 응답값
		Map<String, Object> result = new HashMap<>();
		if(count > 0 ) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "삭제에 실패했습니다.");
		}

		return result;
	}
}
