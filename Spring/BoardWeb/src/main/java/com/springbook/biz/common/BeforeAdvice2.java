package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
	//AOP���� ������ ����ϴ� �޼ҵ尡 ����� �������̽� 

public class BeforeAdvice2 {
	
	public void beforeLog(JoinPoint jp) {
		
		String method = jp.getSignature().getName(); 
			//ó���ϴ� �޼ҵ� �̸��� �˾ƿ� �� �ִ�. 
		Object[] args = jp.getArgs(); 
			//�޼ҵ� ȣ�⿡ � ������ ����ߴ��� �� �� �ִ�.
			//�޼ҵ��� �Ű������� ��ϵ� ���� 
		
		System.out.println("[���� ó��]" + method + "() - �޼ҵ� ���� ");
		System.out.println("[���� ó��] ARGS ���� - " + args[0].toString());
		
	}

}
