package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect       //Aspect : ����Ʈ �� + �����̽� 
public class BeforeAdvice3 {
	
	//////1. ������ �� ���� //////////////////
	
	@Pointcut("execution (* com.springbook.biz..*Impl.*(..))")
	public void allPointCut () {}   //����Ʈ �� �̸��� �����ϴ� �� �޼ҵ� ���� 
	
	@Pointcut("execution (* com.springbook.biz..*Impl.get*(..))")
	public void getPointCut() {}
	
	
	
	////////2.Advice �޼ҵ� : ��� ���͸��� �޼ҵ忡 ����Ǵ� �޼ҵ� ///////////
	@Before ("allPointCut()")
	public void beforeLog(JoinPoint jp) {
		
		String method = jp.getSignature().getName(); 
			//ó���ϴ� �޼ҵ� �̸��� �˾ƿ� �� �ִ�. 
		Object[] args = jp.getArgs(); 
			//�޼ҵ� ȣ�⿡ � ������ ����ߴ��� �� �� �ִ�.
			//�޼ҵ��� �Ű������� ��ϵ� ���� 
		
		System.out.println("[���� ó��-������̼� ����]" + method + "() - �޼ҵ� ���� ");
		System.out.println("[���� ó��-������̼� ����] ARGS ���� - " + args[0].toString());
		
	}
}
