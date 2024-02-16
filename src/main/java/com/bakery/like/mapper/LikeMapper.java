package com.bakery.like.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bakery.like.domain.Like;

@Mapper
public interface LikeMapper {
	
	
	public int insertLikeByUserIdProductId(
			@Param("userId")int userId, 
			@Param("productId")int productId);
	
	public int selectLikeByUserIdProductId(
			@Param("userId")int userId, 
			@Param("productId")int productId);
	
	public int deleteLikeByUserIdProductId(
			@Param("userId")int userId, 
			@Param("productId")int productId);
	
	public List<Like> selectLikeByUserId(int userId);
	
}
