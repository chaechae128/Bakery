package com.bakery.like.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
	
}
