package com.springbook.biz.impl;

import com.springbook.biz.user.UserVO;

public interface UserService {

	//3. CRUD ����� �޼ҵ� ����
	//ȸ�� ���� �˻�(ID�� password�� �Ű������� �޾Ƽ� ó��)
	UserVO getUser(UserVO vo);
	
	UserVO userInsert(UserVO vO);

}