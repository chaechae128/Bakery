package com.bakery.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bakery.like.domain.Like;
import com.bakery.like.mapper.LikeMapper;

@Controller
public class TestController {
	@Autowired
	private LikeMapper likeMapper;
	@RequestMapping("/test1")
	@ResponseBody
	public String test1() {
		return "helloworld";
	}
	
	@RequestMapping("/test2")
	@ResponseBody
	public Map<String, Object> test2() {
		Map<String, Object> result = new HashMap<>();
		result.put("aaa", 111);
		result.put("bbb", 222);
		result.put("ccc", 333);
		return result;
	}
	
	@GetMapping("/test3")
	public String test3() {
		return "test/test";
	}
	
	@ResponseBody
	@RequestMapping("/test4")
	public List<Like> test4(){
		return likeMapper.selectLikeList();
	}
	
}
