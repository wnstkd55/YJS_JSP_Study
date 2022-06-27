package com.springbook.biz.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserVO;

//����Ͻ� ������ ó���ϴ� ���� Ŭ���� : @Service

@Service("userService")
public class UserService1Impl implements UserService1 {
	
	@Autowired							//���� ������ ���� ó���ϵ��� ����
	private UserDAOMybatis userDAO;
	
	@Override
	public void insertUser(UserVO vo) {
		userDAO.insertUser(vo);
	}

	@Override
	public void updateUser(UserVO vo) {
		userDAO.updateUser(vo);
	}

	@Override
	public void deleteUser(UserVO vo) {
		userDAO.deleteUser(vo);
	}

	@Override
	public UserVO getUser(UserVO vo) {
		userDAO.getUser(vo);
		return null;
	}

	@Override
	public List<UserVO> getUserList(UserVO vo) {
		userDAO.getUserList(vo);
		return null;
	}

}
