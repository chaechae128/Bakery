package com.bakery.user.bo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class userBOTest {
	@Autowired
	UserBO userBO;
	
	@Transactional
	@Test
	void 유저추가테스트() {
		log.info("##### 유저 추가 테스트 시작");
		userBO.addUser("aaaa", "sgsgsgte", "aaaa", "aaaa", "aaaa", 75465, "aaaa");
	}

}
