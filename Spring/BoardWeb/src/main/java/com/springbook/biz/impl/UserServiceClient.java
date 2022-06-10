package com.springbook.biz.impl;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.user.UserVO;

public class UserServiceClient {

	public static void main(String[] args) {
		//1. Spring �����̳� ���� 
		
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml"); 
		
		//2. Spring �����̳ʷ� ���� UserServiceImpl ��ü�� Lookup (�����´�)
			//UserService : �������̽� 
		UserService userService = (UserService) container.getBean("userService"); 
		
		//3. �α��� ��� �׽�Ʈ
		UserVO vo = new UserVO(); 
		vo.setId("admin");
		vo.setPassword("1234");
		
		UserVO user = userService.getUser(vo); 
		
		if ( user != null) {  //�α��� ������ ����
			System.out.println(user.getName() + " �� ȯ�� �մϴ�. ");
			System.out.println("���� �޾ƿ� DB�� ����� ID : " + user.getId());
			System.out.println("���� �޾ƿ� DB�� ����� Password : " + user.getPassword());
			System.out.println("���� �޾ƿ� DB�� ����� Name : " + user.getName());
			System.out.println("���� �޾ƿ� DB�� ����� Id : " + user.getId());
			System.out.println("���� �޾ƿ� DB�� ����� role : " + user.getRole());
			
		}else { //�α��� ������ ����
			System.out.println("�α����� ���� �߽��ϴ�. ");
		}
		
		//3-2.insert �޼ҵ� ȣ��  (��������) 
		vo.setId("user200");
		vo.setPassword("1234");
		vo.setName("ȫ�浿200");
		vo.setRole("user");
		
		userService.insertUser(vo);
		
		
		
		//4. Spritn �����̳� ���� 
		container.close();
		
		
	}

}
