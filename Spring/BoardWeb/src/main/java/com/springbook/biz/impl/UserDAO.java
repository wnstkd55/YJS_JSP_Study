package com.springbook.biz.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserVO;

@Repository("userDAO")		//UserDAO Ŭ������ ��üȭ userDAO
public class UserDAO  {
	
	//1. JDBC ���� ���� ���� (conn, pstmt, rs) 
	private Connection conn = null; 
	private PreparedStatement pstmt = null; 
	private ResultSet rs = null; 
	
	//2. SQL ��� ���� ����. 
	private String USER_GET = "select * from users where id = ? and password = ?";
	private String INSERT_USER = "insert into users values (?,?,?,?)"; 
	
	//3. CRUD ����� �޼ҵ� ���� 
		//ȸ�� ���� �˻� (ID�� password�� �Ű������� �޾Ƽ� ó�� ) 
	public UserVO getUser(UserVO vo) {   //vo : �Ű������� ������ �� 
		UserVO user = null;   //user: DB���� select �ؿ� ���� ���� 
		
		try {
			System.out.println("===> JDBC�� getUser() ���ó��");
			conn = JDBCUtil.getConnection(); 
			pstmt = conn.prepareStatement(USER_GET); 
			pstmt.setString(1,vo.getId());
			pstmt.setString(2, vo.getPassword());
			rs = pstmt.executeQuery();  //sql ���� ����� rs�� ��´�. 
				//rs�� ���� �����ϸ� DB�� vo�� �Ѿ���� id�� password �� DB�� �����Ѵ�. 
			
			//rs �� ���� ���� �Ҷ� user (VO) �� �����ؼ� ���� �ؼ� ���� ���� �ش�. 
			
			if (rs.next()) {  // id�� password�� ��ġ�Ҷ� rs.next �� true �� �ô�. 
				user = new UserVO(); 
				user.setId(rs.getString("ID"));
				user.setName(rs.getString("NAME"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setRole(rs.getString("ROLE"));			
			}
					
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
				
		return user; 	
	}
	
	//Insert �޼ҵ� ����  (���� ���� )
	
	public void insertUser(UserVO vo) {
		System.out.println("==> insertUser() ��ɱ���");
		
		try {
			conn = JDBCUtil.getConnection(); 
			pstmt = conn.prepareStatement(INSERT_USER); 
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getRole());
			pstmt.executeUpdate(); 
			
			System.out.println("Insert ���� ");
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
		
	}
	

}
