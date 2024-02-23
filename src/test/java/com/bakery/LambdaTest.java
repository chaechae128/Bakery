package com.bakery;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LambdaTest {
	//@Test
	void 람다테스트1() {
		List<String> fruits = List.of("apple", "banana", "cherry");
		fruits
		.stream() //Stream<String>반환  : 계속 줄줄이 이어지다
		.filter(fruit -> fruit.startsWith("b")) //하나씩 꺼내진 값
		.forEach(fruit -> log.info("### {} ", fruit)); //만약 여러개라면 뭐를 출력?
		//17:06:17.868 [main] INFO com.bakery.LambdaTest -- ### banana 
	}
	
	//@Test
	void 람다테스트2() {
		List<String> fruits = List.of("apple", "banana", "cherry");
		fruits = fruits
		.stream()
		.map(fruit -> fruit.toUpperCase()) // map 하나씩 꺼내서(돌면서) 대문자로 바꿈
		.collect(Collectors.toList()); //새로 만든다  // toList로 변환하는이유는 strem으로 되어있기 때문에 stream to list
		
		log.info(fruits.toString());
	}
	
	@Test
	void 메소드레퍼런스() {
		List<String> fruits = List.of("apple", "banana", "cherry");
		fruits = fruits
				.stream()
				.map(String::toUpperCase) //요소가 있을거고 그\각 요소에 String의 toUpeerCase 메소드를 적용시킬거다
				.collect(Collectors.toList()); //stream to list
		log.info(fruits.toString());
		
	}
}
