package com.springbook.biz.common;

import org.aspectj.lang.annotation.AdviceName;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterAdvice3 {
	
	// 1. ����Ʈ�� ���� //
		//�ܺ� ����Ʈ�� ����ϱ�
	
	// 2. �����̽� ����
	@After("PointCutCommon.allPointCut()")
	public void afterLog() {
		System.out.println("[���� ó��!!!] - ����Ͻ� ���� ������ �۵�");
	}
}
