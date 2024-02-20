package com.bakery;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import lombok.Getter;

public class EnumTest {
	//enum을 만들때는 일종의 도메인을 만들어야ㅎ됨ex) product-domain 에서 enum으로 만들어야함
	
	@Getter
	public enum Status { //Status.Y 
		// 열거형 정의
		Y(1, true), //<- 이게 생성자인 이게 new 하는 것처럼~
		N(0, false)
		;
		
		//enum 에 정의됨 항목의 필드
		private int value1;
		private boolean value2;
		
		//생성자
		Status(int value1, boolean value2) {
			this.value1 = value1;
			this.value2 = value2;
			
		}
	}
	
	@Test
	void status테스트() {
		// given - 준비
		Status status = Status.N;
		
		// when - 실행
		int value1 = status.getValue1();
		boolean value2 = status.isValue2(); //boolean타입은 get이 아니라 is로 꺼내야함
		
		// then - 검증
		assertEquals(status, Status.N); // status는 Status의 Y와 같을 것이다
		assertEquals(0, value1);
		assertEquals(false, value2);
		
	}
}
