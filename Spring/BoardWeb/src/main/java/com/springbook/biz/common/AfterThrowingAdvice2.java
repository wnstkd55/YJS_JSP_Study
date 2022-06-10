package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice2 {
	//AfterThrowing : �ٽ� �������� ���ܰ� �߻� �Ǿ����� ó���Ǵ� Advice
	//Exception exceptionOjb : AOP�� ���̵� ���� 
	
	public void exceptionLog(JoinPoint jp, Exception exceptionObj) {
		String method = jp.getSignature().getName(); 
		
		System.out.println("[���� ó��] " +method + "() �޼ҵ� ������ ���� �߻�");
		System.out.println("[���� ó��] ���ܸ޼��� : " + exceptionObj.getMessage());
		
	}
	

}
