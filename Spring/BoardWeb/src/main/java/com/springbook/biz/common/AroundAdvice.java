package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {
	
	//����Ͻ� ���� ������, ������ �۵� 
	
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		
		System.out.println("[Before] : ����Ͻ� ���� ������ ó��");
		
		Object returnObj = pjp.proceed(); 
		
		System.out.println("[After] : ����Ͻ� ���� ������ ó��");
			
		return returnObj; 
				
	}

}
