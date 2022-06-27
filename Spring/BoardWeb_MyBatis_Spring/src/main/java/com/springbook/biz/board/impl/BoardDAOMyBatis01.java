package com.springbook.biz.board.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

//Spring���� MyBatis ���� DAO ���� ��� 1 : SqlSessionDaoSupport
//@Repository
public class BoardDAOMyBatis01 extends SqlSessionDaoSupport {

	//@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFaction) {
		super.setSqlSessionFactory(sqlSessionFaction);
	}
	
	public void insertBoard(BoardVO vo) {
		getSqlSession().insert("BoardDAO.insertBoard", vo); 
		getSqlSession().commit(); 
	}
	public void updateBoard(BoardVO vo) {
		getSqlSession().update("BoardDAO.updateBoard", vo); 
		getSqlSession().commit(); 
	}
	public void deleteBoard(BoardVO vo) {
		getSqlSession().delete("BoardDAO.deleteBoard", vo);
		getSqlSession().commit(); 		
	}
	public BoardVO getBoard(BoardVO vo) {
		return (BoardVO) getSqlSession().selectOne("BoardDAO.getBoard", vo);	
	}
	public List<BoardVO> getBoardList(BoardVO vo){
		return getSqlSession().selectList("BoardDAO.getBoardList", vo); 
	}
	
	
	
	
}
