package com.springbook.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.user.UserVO;

@Repository("userDAOSpring")
public class UserDAOSpring {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private String USER_GET = "SELECT * FROM users WHERE id = ? AND password = ?";
	private String USER_INSERT = "INSERT INTO users VALUES (?, ?, ?, ?)";
	
	//1. 유저 상세목록
	public UserVO getUser(UserVO vo) {
		System.out.println("==>Spring JDBC로 getUser()기능 처리");
		Object[]args = {vo.getId(),vo.getPassword()};
		return jdbcTemplate.queryForObject(USER_GET,args,new UserRowMapper());
	}
	//2. 유저 가입
	public void insertUsesr(UserVO vo) {
		System.out.println("==>Spring JDBC로 insertUser() 기능 처리");
		jdbcTemplate.update(USER_INSERT,vo.getId(),vo.getPassword(),vo.getName(),vo.getRole());
	}
	
}
