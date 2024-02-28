package com.bakery;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import lombok.Getter;

public class EnumTest2 {
	
	@Getter
	enum PayMethod {
		// 열거형 정의
		REMITANCE("무통장입금")
		, ACCOUNT_TRANSFER("계좌이체")
		, CREDIT("신용카드")
		, NAVER("네이버페이");
		
		// 필드
		private String title;
		
		// 생성자
		PayMethod(String title) {
			this.title = title;
		}
	}
	
	
	enum PayType {
		// 열거형 정의
		CASH("현금", List.of(PayMethod.REMITANCE, PayMethod.ACCOUNT_TRANSFER))
		, CARD("카드", List.of(PayMethod.CREDIT, PayMethod.NAVER))
		, EMPTY("없음", Collections.emptyList()); //비어있는 리스트를 만들어줌

		
		// 필드
		private String title;
		private List<PayMethod> payList;
		
		// 생성자
		PayType(String title, List<PayMethod> payList) {
			this.title = title;
			this.payList = payList;
		}
		
		// 결제 수단(리스트 안의 값) String이 enum에 존재하는지 확인
		public boolean hasPayMethod(PayMethod payMethod) {
			return payList.stream() // payList 순회
					.anyMatch(pay -> pay.equals(payMethod)); //하나라도 같은 게 있으면 true
		}
		
		// 결제수단(String)으로 enum 타입(부모) 찾기  ex) 네이버 페이면? 카드결제
		public static PayType findByPayMethod (PayMethod payMethod) { //타입을 모르니까 static으로 지정
			//전체 열거형을 다 뒤져야함
			return Arrays.stream(PayType.values()) // PayType의 열거형 변수들을 stream으로 변환
					.filter(payType -> payType.hasPayMethod(payMethod)) //payMethod와 같은 type을 뽑아냄  filter얘는 여러개가 뽑힐 수도 있음
					.findAny()  //findAny: 여러개를 filter에서 뽑아냈을 때 랜덤으로 뽑아냄 : 찾은 요소 반환
					.orElse(EMPTY); //없으면 PayType.EMPTY를 리턴
		}
	}
	@Test
	void pay테스트2() {
		//given
		PayMethod payMethod = PayMethod.ACCOUNT_TRANSFER;
		
		//when
		PayType payType = PayType.findByPayMethod(payMethod);
		
		//then
		assertEquals(PayType.CASH, payType);
		assertEquals("계좌이체", payMethod.getTitle());
		
	}
	
	
	//@Test
//	void pay테스트() {
//		// given
//		String payMethod = "NAVER";
//		// when - 결제 수단에 해당하는 결제 종류는?
//		PayType payType = PayType.findByPayMethod(payMethod);
//		// then
//		assertEquals(payType, PayType.CARD);
//	}
}
