package com.bakery.order;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/order")
@RestController
public class OrderRestController {
	@RequestMapping("/create")
	public Map<String, Object> create(){
		Map<String, Object> result = new HashMap<>();
		if(1 > 0 ) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "삭제에 실패했습니다.");
		}

		return result;
	}
}
