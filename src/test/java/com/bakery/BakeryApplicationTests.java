package com.bakery;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ObjectUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class BakeryApplicationTests {

	
	@Test
	void 비어있는지확인() {
		//List<Integer> list = new ArrayList<>(); // []
		List<Integer> list = null; // []
		if(ObjectUtils.isEmpty(list)) { //null 이든 []비어있는 array이든 true가 된다.
			log.info("list is empty");
		}
		
		//String str = null;
		String str = "";
		if(ObjectUtils.isEmpty(str)) {
			log.info("str is empty");
		}
	}


}
