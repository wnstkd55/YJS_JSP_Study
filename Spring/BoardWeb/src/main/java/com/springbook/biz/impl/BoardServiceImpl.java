package com.springbook.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.BoardVO;
import com.springbook.biz.common.Log4jAdvice;
import com.springbook.biz.common.LogAdvice;

@Service ("boardService")     //����Ͻ� ������ ó���ϴ� Ŭ���� (BoardServiceImpl.java)   
public class BoardServiceImpl implements BoardService {
	
	//@Autowired		//��ü ���� 
	//private BoardDAO boardDAO;		//JSP ���� ������ DAO 
	
	@Autowired			
	private BoardDAOSpring boardDAO; 	//Spring ���� ������ DAO 
	
	
	//��� �޼ҵ尡 ����Ǳ� ���� Log �� ���ܾ� �Ѵ�. 
	//private LogAdvice log;    //��ü ���� 
	//private Log4jAdvice log2; 
	
	public BoardServiceImpl () {   //�⺻ ������ ȣ��� log ��ü ���� 
		//log = new LogAdvice(); 
		//log2 = new Log4jAdvice(); 
	}

	@Override
	public void insertBoard(BoardVO vo) {
		//log.printLog();
		//log2.printLogging();
		
		//���� ���� �߻� 
		/*
		if (vo.getSeq() == 0 ) {
			//throw new IllegalArgumentException("0 �� ���� ��� �� �� �����ϴ�. ");
			throw new NumberFormatException ("�������� ���� �Էµ�");
		}
		*/
		
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		//log.printLog();
		//log2.printLogging();
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		//log.printLog();
		//log2.printLogging();
		boardDAO.deleteBoard(vo);

	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		//log.printLog();
		//log2.printLogging();
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		//log.printLog();
		//log2.printLogging();
		return boardDAO.getBoardList(vo);
	}

}
