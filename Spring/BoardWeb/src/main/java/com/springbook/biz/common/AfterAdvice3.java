package com.springbook.biz.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterAdvice3 {
	
	///////1.������ �� ���� ////////
		//�ܺ� ����Ʈ�� ����ϱ� 

	//////2. �����̽� ���� 
	@After ("PointCutCommon.getPointCut()")
	public void afterLog( ) {
		System.out.println("[���� ó��^^] - ����Ͻ� ���� ������ �۵�");
	}
	
	
}
