package com.bakery.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component // singleton  service도 아니도 controller도 아니고 애매할 때
@Aspect // 부가 기능 정의(advice) + 어디에 적용(pointcut) 
public class TimeTraceAop {
	// 경로 지적 or 특정 패키지
	
	//1) 수행할 패키지 지정
	//@Around("execution(* com.bakery..*(..))")
	//2) 어노테이션 지정
	@Around("@annotation(TimeTrace)") //어느 어노테이션이 붙어 있을 때 수행되는가?
	public Object excute(ProceedingJoinPoint joinPoint) throws Throwable {
		//joinPoint: 타켓이 적용하는 메소드 ex)회원가입, 로그인 ...
		
		//시간 측정
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		// 본래 할 일 수행 (ex 회원가입, 로그인...)
		Object proceedObj = joinPoint.proceed();
		
		// 시간 측정 종료
		stopWatch.stop();
		
		log.info("$$$$$$$$$ 실행 시간(ms): {}", stopWatch.getTotalTimeMillis());
		log.info("********* 실행 시간:" + stopWatch.prettyPrint());
		
		return proceedObj;
	}
}
