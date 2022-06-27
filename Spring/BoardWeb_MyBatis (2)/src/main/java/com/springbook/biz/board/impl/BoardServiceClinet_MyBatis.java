package com.springbook.biz.board.impl;

import java.sql.SQLException;
import java.util.List;

import com.springbook.biz.board.BoardVO;

public class BoardServiceClinet_MyBatis {
	
	public static void main(String[] args) throws SQLException{
		
		
		BoardDAOMyBatis boardDAO = new BoardDAOMyBatis();
		
		BoardVO vo = new BoardVO(); 
		
		vo.setTitle("new - myBatis ����");
		vo.setWriter("ȫ�浿");
		vo.setContent("new-myBatis �����Դϴ�. " );
		
		boardDAO.insertBoard(vo);
		
		//NULL���� �Ѿ�� �ʵ��� �⺻����
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		
		
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		for(BoardVO board : boardList) {
			System.out.println("--->" + board.toString());
		}
			
	}
	
}
	


