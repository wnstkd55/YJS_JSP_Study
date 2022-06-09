package com.springbook.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.BoardVO;
import com.springbook.biz.common.Log4jAdvice;
import com.springbook.biz.common.LogAdvice;

@Service("boardService")		//비즈니스 로직을 처리하는 클래스(BoardServiceImpl.java)
public class BoardServiceImpl implements BoardService {
	
	//@Autowired	//객체 주입
	//private BoardDAO boardDAO;		//JSP에서 구현한 DAO
	
	@Autowired
	private BoardDAOSpring boardDAO;		//Spring에서 구현한 DAO
	
	//모든 메소드가 실행하기 전에 Log를 남겨야 된다.
	//private LogAdvice log;	//객체 선언
	//private Log4jAdvice log2;
	
	public BoardServiceImpl() {		//기본 생성자 호출시 log객체 생성
		//log2 = new Log4jAdvice();
	}
	
	@Override
	public void insertBoard(BoardVO vo) {
		//log.printLog();
		//log2.printLogging();
		
		//예외 강제 발생
//		if(vo.getSeq() == 0) {
//			throw new NumberFormatException("0번 글은 등록할 수 없습니다.");
//		}
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
