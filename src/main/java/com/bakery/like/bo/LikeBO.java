package com.bakery.like.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bakery.like.domain.Like;
import com.bakery.like.mapper.LikeMapper;

@Service
public class LikeBO {
	@Autowired
	private LikeMapper likeMapper;
	
	public int insertLikeByUserIdProductId(int userId, int productId) {
		return likeMapper.insertLikeByUserIdProductId(userId, productId);
	}
	
	public int deleteLikeByUserIdProductId(int userId, int productId) {
		return likeMapper.deleteLikeByUserIdProductId(userId, productId);
	}
	
	public List<Like> selectLikeByUserId(int userId) {
		return likeMapper.selectLikeByUserId(userId);
	}
}
