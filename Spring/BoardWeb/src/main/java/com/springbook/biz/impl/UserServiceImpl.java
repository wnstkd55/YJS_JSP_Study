package com.springbook.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserVO;

@Service("userService")		//����Ͻ� ������ ó���ϴ� Ŭ����
public class UserServiceImpl implements UserService {
	
	//��ü ����(DI)
		//1. �����ڸ� ���� ����		( XML ���� )
		//2. Setter ����			( XML ���� )
		//3. ������̼�(@)�� Ȱ���� ���� ( @Autowired )
	
	@Autowired						//��ü ����(Ÿ������ ����), ������̼����� ��ü ����
	private UserDAO userDAO;
	
	//Setter�� ����ؼ� ��ü ���� (xml����)
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	//�����ڸ� �̿��� ��ü ���� (XML ����)
//	public UserServiceImpl(UserDAO userDAO) {
//		this.userDAO = userDAO;
//	}
	
	@Override
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}

	@Override
	public UserVO userInsert(UserVO vo) {
		return userDAO.userInsert(vo);
		
	}

	

}
