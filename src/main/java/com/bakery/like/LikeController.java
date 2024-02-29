package com.bakery.like;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bakery.like.bo.LikeBO;
import com.bakery.like.domain.Like;
import com.bakery.product.bo.ProductBO;
import com.bakery.product.entity.ProductEntity;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/like")
public class LikeController {
	@Autowired
	private LikeBO likeBO;
	
	@Autowired
	private ProductBO productBO;
	
	@GetMapping("/like-list-view")
	public String productManageView(Model model
			,HttpSession session) {
		int userId = (int)session.getAttribute("userId");
		List<Like> likeList = likeBO.selectLikeByUserId(userId);
		List<ProductEntity> productList = productBO.selectBylikeList(likeList);
		model.addAttribute("productList", productList);
		model.addAttribute("viewName", "/myPage/like");
		model.addAttribute("userId", userId);

		return "template/bakeryLayout";
	}
}
