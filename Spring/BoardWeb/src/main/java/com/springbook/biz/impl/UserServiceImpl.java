package com.springbook.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserVO;

@Service ("userService")    //����Ͻ� ������ ó���ϴ� Ŭ���� 
public class UserServiceImpl implements UserService {
	
	//��ü ���� (DI) 
		//1. �����ڸ� ���� ����     ( XML ���� )
		//2. Setter�� ����� ����  ( XML ���� ) 
		//3. ������̼��� �̿��� ���� (@Autowired , ) 
	
	//@Autowired					//��ü ���� (Ÿ������ ����) , ������̼����� ��ü ���� 
	//private UserDAO userDAO; 
	@Autowired
	private UserDAOSpring userDAO; 
	
	// Setter �� ����ؼ� ��ü ���� (XML ����)
	/*
	public void setUserDAO (UserDAO userDAO) {
		this.userDAO = userDAO; 
	}
	*/
	//�����ڸ� �̿��� ��ü ���� (XML ����)
	/*
	public UserServiceImpl(UserDAO userDAO) {
		this.userDAO = userDAO; 
	}
	*/ 
	

	@Override
	public UserVO getUser(UserVO vo) {
		
		return userDAO.getUser(vo);
	}

	@Override
	public void insertUser(UserVO vo) {
		
		userDAO.insertUser(vo);	//Insert �ߵ�.
		//userDAO.insertUser(vo);	//Primary key ���� �߻�
		
	}
	


}
