package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;


@Service("boardService")
public class BoardServiceImpl implements BoardService {


	//@Autowired					//Ÿ������ ��ü ����
	//private BoardDAO boardDAO;
				//MVC M1, M2, MVC_Pramework �� View
	//@Autowired
	//private BoardDAOSpring boardDAO;  //Spring �� BoardDAO
	//private BoardDAOJPA boardDAO;
	//private BoardDAO boardDAO;
	
	@Autowired
	private BoardDAOMyBatis boardDAO; 



	@Override
	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}
}