package com.springbook.biz.impl;

import java.util.List;

import com.springbook.biz.BoardVO;

public interface BoardService {   //�������̽� : ��üȭ �� �� ����. 

	//CRUD�� ���� �ϴ� �޼ҵ� ���� 
	//3. Insert �޼ҵ� ����  (�� ���) 
	void insertBoard(BoardVO vo);

	//4. Update �޼ҵ� ���� (�� ����)
	void updateBoard(BoardVO vo);

	//5. Delete �޼ҵ� ���� (�� ����)
	void deleteBoard(BoardVO vo);

	//6. Select �޼ҵ� ����  (�󼼳���) (�� �� ��ȸ)
	BoardVO getBoard(BoardVO vo);

	//7. Select �޼ҵ� ���� (List ) (�� ��� ��ȸ )
	List<BoardVO> getBoardList(BoardVO vo);

}