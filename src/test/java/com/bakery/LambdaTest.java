package com.bakery;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import lombok.AllArgsConstructor;
import lombok.ToString;
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
	
	//@Test
	void 메소드레퍼런스() {
		List<String> fruits = List.of("apple", "banana", "cherry");
		fruits = fruits
				.stream()
				.map(String::toUpperCase) //요소가 있을거고 그\각 요소에 String의 toUpeerCase 메소드를 적용시킬거다
				.collect(Collectors.toList()); //stream to list
		log.info(fruits.toString());
	}
	
	@Test
	void 람다_메소드레퍼런스() {
		List<Person> personList = new ArrayList<>();
		personList.add(new Person("김채연", 23));
		personList.add(new Person("권지용", 37));
		
		//객체 안에 있는 메소드 호출
		//원래는 list안에서 i로 돌텐데
		personList.forEach(p -> p.printInfo()); //람다
		personList.forEach(Person::printInfo); //메소드 레퍼런스 : 그 객체가 이미 있다고 생각 - 내가 꺼낼 dataType은 이건데 그 안에 있는 ~~메소드를 쓰겠다
		
		
		//객체를 println으로 출력
		personList.forEach(p -> System.out.println(p)); // 람다
		personList.forEach(System.out::println); // 메소드 레퍼런스
	}
	
	@ToString //이게 들어가면 안쪽에 있는 내용물을 보여줌
	@AllArgsConstructor
	class Person {
		private String name;
		private int age;
		
		public void printInfo() {
			log.info("### " + this);
		}
		
		
	}
}
