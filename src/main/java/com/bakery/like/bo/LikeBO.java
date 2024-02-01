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
	public List<Like> selectLikeList(){
		return likeMapper.selectLikeList();
	}
}
