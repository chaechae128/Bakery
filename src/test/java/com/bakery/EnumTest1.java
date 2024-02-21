package com.bakery;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.Function;

import org.junit.jupiter.api.Test;

public class EnumTest1 {

	public enum CalcType {
		//열거형 정의   종속이 되는 것을 괄호 안에 넣기
		CALC_A(value -> value), //value가 들어오면 그대로 value로 리턴 즉 input->output
		CALC_B(value -> value * 10),
		CALC_C(value -> value * 3),
		CALC_ETC(value -> 0);
		
		// enum에 정의된 function 
		//function을 필드로 정의
		private Function<Integer, Integer> expression;
		
		// 생성자
		CalcType(Function<Integer, Integer> expression) { //public 붙여도되고 안 붙여도 됨
			this.expression = expression;
		}
		
		// 계산 적용 메소드
		public int calculate(int value) {
			return expression.apply(value);   //내가 가지는 expression 의 
		}
	}
	
	@Test
	void cal테스트() {
		// given - 준비
		CalcType calcType = CalcType.CALC_C;
		
		// when - 실행
		int result = calcType.calculate(500);
		
		// then - 검증
		assertEquals(1500, result);
		
	}
}
