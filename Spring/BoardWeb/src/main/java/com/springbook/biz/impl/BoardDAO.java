package com.springbook.biz.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.BoardVO;
import com.springbook.biz.common.JDBCUtil;

//Bean ���  : ������̼� ��� ����. @Component 
@Repository ("boardDAO")
public class BoardDAO  {
	
	//1. JDBC ���� ���� ���� 
	private Connection conn = null; 
	private PreparedStatement pstmt = null; 
	private ResultSet rs = null; 
	
	//2. SQL ���� ���� (����� ���� ) 
	private final String BOARD_INSERT = "insert into board (seq, title, writer,content) "
			+ "	values ((select nvl (max(seq), 0)+1 from board) , ?, ?, ?)"; 
	private final String BOARD_UPDATE = "update board set title = ? , content = ? "
			+ "where seq = ?"; 
	private final String BOARD_DELETE = "delete board where seq = ?"; 
	private final String BOARD_GET = "select * from board where seq = ?"; 
	private final String BOARD_LIST = "select * from board order by seq desc"; 
	private final String BOARD_LIST_T = "select * from board where title like '%'||?||'%' "
							+ "order by seq desc";   //�� �������� �˻� ����
	private final String BOARD_LIST_C = "select * from board where content like '%'||?||'%' "
							+ "order by seq desc";   //�� �������� �˻� ���� 
	
	//CRUD�� ���� �ϴ� �޼ҵ� ���� 
	//3. Insert �޼ҵ� ����  (�� ���) 
	public void insertBoard(BoardVO vo) {
		 System.out.println("==> JDBC�� insertBoard() ��� ó���� ");
		 
		 try {
			 conn = JDBCUtil.getConnection();  // Connection��ü ȣ�� 
			 pstmt = conn.prepareStatement(BOARD_INSERT); 
			 pstmt.setString(1, vo.getTitle());
			 pstmt.setString(2, vo.getWriter());
			 pstmt.setString(3, vo.getContent());
			 pstmt.executeUpdate(); 
			 System.out.println("insert ������");
			 
		 }catch (Exception e) {
			 e.printStackTrace();
		 }finally {
			 JDBCUtil.close(pstmt, conn);   //��ü ���� 
		 }
	}
	
	//4. Update �޼ҵ� ���� (�� ����)
	public void updateBoard(BoardVO vo) {
		System.out.println("==> JDBC�� updateBoard() ��� ó���� ");
		try {
			conn = JDBCUtil.getConnection(); 
			pstmt = conn.prepareStatement(BOARD_UPDATE); 
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getSeq());     
			pstmt.executeUpdate(); 
			System.out.println("�� ���� ����");
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
		
	//5. Delete �޼ҵ� ���� (�� ����)
	public void deleteBoard(BoardVO vo) {
		System.out.println("==> JDBC�� deleteBoard() ��� ó���� ");
		try {
			conn = JDBCUtil.getConnection(); 
			pstmt = conn.prepareStatement(BOARD_DELETE); 
			pstmt.setInt(1, vo.getSeq());
			pstmt.executeUpdate(); 
			System.out.println("�� ���� ����");
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}

	//6. Select �޼ҵ� ����  (�󼼳���) (�� �� ��ȸ)
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("==> JDBC�� getBoard() ��� ó���� ");
		BoardVO board = null; 
		
		try {
			conn = JDBCUtil.getConnection(); 
			pstmt = conn.prepareStatement(BOARD_GET); 
			pstmt.setInt(1, vo.getSeq());
			rs = pstmt.executeQuery(); 
			
			if (rs.next()) {   // select �� ������� ���� �Ѵٸ� , rs�� ���� board �� setter ����
				board = new BoardVO(); 
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegdate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));			
			}		
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return board;    // �޼ҵ带 ȣ���ϴ� ������ DB���� ������ ���� ���� 
	}
	
	//7. Select �޼ҵ� ���� (List ) (�� ��� ��ȸ )
	public List<BoardVO> getBoardList(BoardVO vo) {
		
		System.out.println("==> JDBC�� getBoardList() ��� ó���� ");
		
		List<BoardVO> boardList = new ArrayList<BoardVO>(); 
		
		try {
			conn= JDBCUtil.getConnection(); 
			pstmt = conn.prepareStatement(BOARD_LIST); 
			rs = pstmt.executeQuery();
			
			System.out.println("�� ��� ��ȸ ���� ");
			
			while (rs.next()) { // DB���� Select �� ��� ���� vo�� ���� �ؼ� 
									// ������ vo ��ü�� ArrayList�� �����ؼ� ���� 
				BoardVO board = new BoardVO(); 
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER")); 
				board.setContent(rs.getString("CONTENT")); 
				board.setRegdate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("CNT"));
				
				boardList.add (board); 		//board �� ArrayList �� ������. 		
			}
			
		}catch (Exception e) {
			
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
				
		return boardList; 
	}
	
	
	

}
