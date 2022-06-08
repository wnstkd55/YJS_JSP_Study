package com.springbook.biz.impl;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.user.UserVO;

public class UserServiceClient {

	public static void main(String[] args) {
		//1. Spring 컨테이너 구동
		
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. Spring 컨테이너로부터 UserServiceImpl 객체를 Lookup(가져온다.)
		UserService userService = (UserService)container.getBean("userService");
		
		//3. 로그인 기능 테스트
		UserVO vo = new UserVO();
		vo.setId("user");
		vo.setPassword("1234");
		
		UserVO user = userService.getUser(vo);
		
		if(user != null) {	//로그인이 성공한 상태
			System.out.println(user.getName()+"님 환영합니다.");
			System.out.println("리턴 받아온 DB에 저장된 id를 출력 : "+user.getId());
			System.out.println(user.getName()+" 님의 역할은 "+user.getRole()+" 입니다.");
			
		}else { //로그인이 실패한 상태
			System.out.println("로그인이 실패햐였습니다.");
		}
		
		//3-2 insert 메소드 호출(수정사항)
//		UserVO vo1 = new UserVO();
//		
//		vo1.setId("choi");
//		vo1.setPassword("1234");
//		vo1.setName("최민규");
//		vo1.setRole("User");
//		
//		vo1.setId("kim");
//		vo1.setPassword("1234");
//		vo1.setName("김유신");
//		vo1.setRole("User");
//		
//		vo1.setId("Yoo");
//		vo1.setPassword("1234");
//		vo1.setName("유준상");
//		vo1.setRole("User");
//		
//		UserVO user1 = userService.userInsert(vo1); 
		//4. spring 컨테이너 종료
		container.close();
	}

}
