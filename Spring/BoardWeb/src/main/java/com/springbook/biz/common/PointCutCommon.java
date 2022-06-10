package com.springbook.biz.common;

import org.aspectj.lang.annotation.Pointcut;

public class PointCutCommon {
	//�ܺ� ����Ʈ �� Ŭ���� ����� ( ����Ʈ �Ƹ� �����ϴ� Ŭ���� )
	
	@Pointcut("execution (* com.springbook.biz..*Impl.*(..))")
	public void allPointCut () {}   //����Ʈ �� �̸��� �����ϴ� �� �޼ҵ� ���� 
	
	@Pointcut("execution (* com.springbook.biz..*Impl.get*(..))")
	public void getPointCut() {}

}
