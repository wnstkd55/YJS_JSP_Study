package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice2 {
	//AfterThrowing : 핵심 로직에서 예외가 발생되었을때 처리되는 Advice
	//Exception exceptionObj : AOP의 바인드 변수
	
	public void exceptionLog(JoinPoint jp, Exception exceptionObj) {
		String method = jp.getSignature().getName();
		
		System.out.println("[에외 처리] "+ method);
		System.out.println("[에외 처리] 예외메세지 : "+ exceptionObj.getMessage());
	}
	
}
