package com.bakery.like.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bakery.like.domain.Like;

@Mapper
public interface LikeMapper {
	public List<Like> selectLikeList();
}
