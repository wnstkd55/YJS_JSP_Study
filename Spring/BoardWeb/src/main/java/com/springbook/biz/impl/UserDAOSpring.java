package com.springbook.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.user.UserVO;

@Repository("userDAOSpring")
public class UserDAOSpring {
	
	@Autowired			//jdbcTemplate ��ü Ȱ��ȭ 
	private JdbcTemplate jdbcTemplate;  
	
	
	private String USER_GET = "select * from users where id = ? and password = ?";
	private String INSERT_USER = "insert into users values (?,?,?,?)"; 

	//�� �� ��� ���
	public UserVO getUser(UserVO vo) {
		System.out.println("===> Spring JDBC�� getUser() ��� ����");
		Object[] args = {vo.getId(), vo.getPassword()};
		return jdbcTemplate.queryForObject(USER_GET, args, new UserRowMapper());
	}
	
	//�� ��� 
	
	public void insertUser(UserVO vo) {
		System.out.println("===> Spring JDBC�� insertUser() ��� ����");
		jdbcTemplate.update(INSERT_USER, vo.getId(),vo.getPassword(),vo.getName(),vo.getRole());
	}
	
	
	

}
