package com.springbook.biz.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserVO;

@Repository("userDAO")		//UserDAOŬ������ ��üȭ userDAO
public class UserDAO{
	
	//1. JDBC ���� ���� ����(conn, pstmt, rs)
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//2. SQL ��� ���� ����.
	private String USER_GET = "SELECT * FROM users WHERE id = ? AND password = ?";
	private String USER_INSERT = "INSERT INTO users VALUES (?, ?, ?, ?)";
	//3. CRUD ����� �޼ҵ� ����
		//ȸ�� ���� �˻�(ID�� password�� �Ű������� �޾Ƽ� ó��)
	public UserVO getUser(UserVO vo) {	//vo : �Ű������� ������ ��
		UserVO user = null;		//user : DB���� select �ؿ� ���� ����
		
		try {
			System.out.println("===> JDBC�� getUser()��� ó��");
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(USER_GET);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			
			rs = pstmt.executeQuery();	//sql ���� ����� rs�� ��´�.
			//rs�� ���� �����ϸ� DB�� id�� �Ű�����(vo)�� �Ѿ�� id, password db�� �����Ѵ�
			
			if(rs.next()) {	//id�� password�� ��ġ�Ҷ� rs.next�� true�� �ȴ�.
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
	
	//INSERT ��������
	
	public UserVO userInsert(UserVO vo) {
		UserVO user = null;
		try {
			System.out.println("===> JDBC�� userInsert()��� ó��");
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
