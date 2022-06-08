package com.springbook.biz.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserVO;

@Repository("userDAO")		//UserDAO클래스를 객체화 userDAO
public class UserDAO{
	
	//1. JDBC 관련 변수 선언(conn, pstmt, rs)
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//2. SQL 상수 구문 적용.
	private String USER_GET = "SELECT * FROM users WHERE id = ? AND password = ?";
	private String USER_INSERT = "INSERT INTO users VALUES (?, ?, ?, ?)";
	//3. CRUD 기능의 메소드 구현
		//회원 정보 검색(ID와 password를 매개변수로 받아서 처리)
	public UserVO getUser(UserVO vo) {	//vo : 매개변수로 들어오는 값
		UserVO user = null;		//user : DB에서 select 해온 값을 리턴
		
		try {
			System.out.println("===> JDBC로 getUser()기능 처리");
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(USER_GET);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			
			rs = pstmt.executeQuery();	//sql 실행 결과를 rs에 담는다.
			//rs의 값이 존재하면 DB의 id와 매개변수(vo)로 넘어온 id, password db에 존재한다
			
			if(rs.next()) {	//id와 password가 일치할때 rs.next가 true가 된다.
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		
		return user;
	}
	
	//INSERT 수정사항
	
	public UserVO userInsert(UserVO vo) {
		UserVO user = null;
		try {
			System.out.println("===> JDBC로 userInsert()기능 처리");
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(USER_INSERT);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getRole());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
		return user;
	}
}
