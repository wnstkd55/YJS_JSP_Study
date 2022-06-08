package com.springbook.biz.impl;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.user.UserVO;

public class UserServiceClient {

	public static void main(String[] args) {
		//1. Spring �����̳� ����
		
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. Spring �����̳ʷκ��� UserServiceImpl ��ü�� Lookup(�����´�.)
		UserService userService = (UserService)container.getBean("userService");
		
		//3. �α��� ��� �׽�Ʈ
		UserVO vo = new UserVO();
		vo.setId("user");
		vo.setPassword("1234");
		
		UserVO user = userService.getUser(vo);
		
		if(user != null) {	//�α����� ������ ����
			System.out.println(user.getName()+"�� ȯ���մϴ�.");
			System.out.println("���� �޾ƿ� DB�� ����� id�� ��� : "+user.getId());
			System.out.println(user.getName()+" ���� ������ "+user.getRole()+" �Դϴ�.");
			
		}else { //�α����� ������ ����
			System.out.println("�α����� �����ῴ���ϴ�.");
		}
		
		//3-2 insert �޼ҵ� ȣ��(��������)
//		UserVO vo1 = new UserVO();
//		
//		vo1.setId("choi");
//		vo1.setPassword("1234");
//		vo1.setName("�ֹα�");
//		vo1.setRole("User");
//		
//		vo1.setId("kim");
//		vo1.setPassword("1234");
//		vo1.setName("������");
//		vo1.setRole("User");
//		
//		vo1.setId("Yoo");
//		vo1.setPassword("1234");
//		vo1.setName("���ػ�");
//		vo1.setRole("User");
//		
//		UserVO user1 = userService.userInsert(vo1); 
		//4. spring �����̳� ����
		container.close();
	}

}
