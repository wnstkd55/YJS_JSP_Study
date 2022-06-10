package com.springbook.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect		//Aspect = Pointcut + Advice 
public class LogAdvice3 {
	
	//////////1. ����Ʈ �� ���� : ������ �޼ҵ��� ���͸� ///////////////////////////
	
	@Pointcut("execution (* com.springbook.biz..*Impl.*(..))")
	public void allPointCut () {}   //����Ʈ �� �̸��� �����ϴ� �� �޼ҵ� ���� 
	
	@Pointcut("execution (* com.springbook.biz..*Impl.get*(..))")
	public void getPointCut() {}
	
	
	///////////2. �����̽� //////////////////////////////////////////////
	@Before("allPointCut()")
	public void printLog() {
		System.out.println("[����α�] ��� ���� ���� �� ���� (������̼� �۵�)");
	}
	
	
}
