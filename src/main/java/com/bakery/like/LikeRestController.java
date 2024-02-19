package com.bakery.like;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bakery.like.bo.LikeBO;
import com.bakery.like.domain.Like;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/like")
@RestController
public class LikeRestController {
	
	@Autowired
	private LikeBO likeBO;
	
	@RequestMapping("/like")
	public Map<String, Object> like(
			@RequestParam("productId") int productId,
			HttpSession session) {
		Map<String, Object> result = new HashMap<>();
		Integer userId = (Integer)session.getAttribute("userId");
		//로그인 되어있는지 확인
		if (userId == null) {
			result.put("code", 300);
			result.put("error_message", "로그인이 되어있지 않습니다. 로그인 후 이용해주세요");
			return result;
		}
		
		if (likeBO.insertLikeByUserIdProductId(userId, productId) > 0 ) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "실패");
		}
		
		return result;
	}
	@RequestMapping("/dislike")
	public Map<String, Object> dislike(
			@RequestParam("productId") int productId,
			HttpSession session) {
		Map<String, Object> result = new HashMap<>();
		Integer userId = (Integer)session.getAttribute("userId");
		//로그인 되어있는지 확인
		if (userId == null) {
			result.put("code", 300);
			result.put("error_message", "로그인이 되어있지 않습니다. 로그인 후 이용해주세요");
			return result;
		}
		
		if (likeBO.deleteLikeByUserIdProductId(userId, productId) > 0 ) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "실패");
		}
		
		
		return result;
	}
	
	
	
}
