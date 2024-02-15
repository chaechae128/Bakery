package com.bakery.batch;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component 
public class TestBatch {
	//이게 하나의 job
	@Scheduled(cron = "0 */1 * * * *") //cron tab문법 사용  0초에 */1 매 1분마다  /<- 매 ~마다
	public void task() {
		log.info("####### batch 수행 ");
	}
}
