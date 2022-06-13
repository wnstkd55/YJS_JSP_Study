package com.springbook.biz.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO_;

//@Repository
public class BoardDAOMybatis{
	
	@Autowired
	private SqlSessionTemplate mybatis;

	public void insertBoard(BoardVO_ vo) {
		System.out.println("===> Mybatis�� insertBoard() ��� ó��");
		mybatis.insert("BoardDAO.insertBoard", vo);
	}

	public void updateBoard(BoardVO_ vo) {
		System.out.println("===> Mybatis�� updateBoard() ��� ó��");
		mybatis.update("BoardDAO.updateBoard", vo);
	}

	public void deleteBoard(BoardVO_ vo) {
		System.out.println("===> Mybatis�� deleteBoard() ��� ó��");
		mybatis.delete("BoardDAO.deleteBoard", vo);
	}

	public BoardVO_ getBoard(BoardVO_ vo) {
		System.out.println("===> Mybatis�� getBoard() ��� ó��");
		return (BoardVO_) mybatis.selectOne("BoardDAO.getBoard", vo);
	}

	public List<BoardVO_> getBoardList(BoardVO_ vo) {
		System.out.println("===> Mybatis�� getBoardList() ��� ó��");
		return mybatis.selectList("BoardDAO.getBoardList", vo);
	}
}