package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserVO;

@Service
@Aspect
public class AfterReturningAdvice3 {
	
	//AfterReturning : �ٽ�(����Ͻ�) ������ �޼ҵ尡 ���������� ���������� �۵� 

	///////1.������ �� ���� ////////
	@Pointcut("execution (* com.springbook.biz..*Impl.*(..))")
	public void allPointCut () {}   //����Ʈ �� �̸��� �����ϴ� �� �޼ҵ� ���� 
	
	@Pointcut("execution (* com.springbook.biz..*Impl.get*(..))")
	public void getPointCut() {}
	
	////////2. �����̽�/////////
	@AfterReturning( pointcut = "allPointCut ()", returning = "returnObj")
	public void afterReturningLog(JoinPoint jp, Object returnObj ) {
		//AOP�� ���ε� ���� : Object returnObj
		// afterReturning : �ٽ� ������ ������ ���ϰ��� ���������� ����ɶ� �۵��Ǵ�
		// Object returnObj �� �ٽ� ������ ����ǰ� ���ϵǴ� ��ü�� �Ű������� �޴´�. 
		
		String method = jp.getSignature().getName(); 
		
		if (returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj; 
			if (user.getRole().equals("Admin")) {
				System.out.println(user.getName() + "�α��� (admin)");
			}		
		}
		
		System.out.println("[���� ó��] �޼ҵ� �� " + method + "()" );
	//	System.out.println("[���� ó��] �޼ҵ� ���ϰ� : " + returnObj.toString());
	}

	
	
}
