package com.bakery.like;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bakery.like.bo.LikeBO;
import com.bakery.like.domain.Like;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/like")
public class LikeController {
	@Autowired
	private LikeBO likeBO;
	
	
	@GetMapping("/like-list-view")
	public String productList(
			HttpSession session,
			Model model){
		int userId = (Integer)session.getAttribute("userId");
		
		List<Like> likeList = likeBO.selectLikeByUserId(userId);
		model.addAttribute("likeList", likeList);
		
		model.addAttribute("viewName", "/myPage/like");
		return "template/bakeryLayout";
	}
}
