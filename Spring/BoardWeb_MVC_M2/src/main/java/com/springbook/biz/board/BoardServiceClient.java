package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;


public class BoardServiceClient {
	public static void main(String[] args) {
		// 1. Spring �����̳ʸ� �����Ѵ�.
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");

		// 2. Spring �����̳ʷκ��� BoardServiceImpl ��ü�� Lookup�Ѵ�.
		BoardService boardService = 
				(BoardService) container.getBean("boardService");

		// 3. �� ��� ��� �׽�Ʈ
		BoardVO vo = new BoardVO();
		//vo.setSeq(200);             // �ӽ÷� ���� �߻� ��Ű�� ���ؼ� ����(AfterThrowing ����)
		vo.setTitle("�� ����300");
		vo.setWriter("ȫ�浿300");
		vo.setContent("�� ����300..............");
		boardService.insertBoard(vo);
		

		// 4. �� ��� �˻� ��� �׽�Ʈ
		
		vo.setSearchCondition("TITLE");  //SQL�� TITLE �÷��� �˻�
		vo.setSearchKeyword("��");		// TITLE �÷��� �� "�ӽ�" �˻� 
	
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
		

		
		// 5. Spring �����̳� ����
		container.close();
		
		
	}
}