package com.springbook.biz.board;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BoardVO {
	
	private int seq; 
	private String title; 
	private String writer; 
	private String content; 
	private Date regdate; 
	private int cnt;
	private String searchCondition;
	private String searchKeyword;
	private MultipartFile uploadFile;
	
	//getter , setter
	
	//@JsonIgnore   : getter ���� ���� , Ư�� ������ JSON �������� ��ȯ���� �ʵ��� �����Ҷ� ���. 
	
	@JsonIgnore
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	
	@JsonIgnore
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	
	@JsonIgnore
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	
	
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	
	
	
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	@JsonIgnore
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	} 
	
	@Override
	public String toString () {	//��ü ��ü�� ��½� ��ü�� �ּҸ� ��� �ϴ� ���� �ƴ϶� 
								  // ��ü�� �޸��� ���� ��� 
		
		return "BoardVO [seq = " + seq + ", title = " + title + ", writer = " + writer +
				" , content = " + content + " , regdate = " + regdate + " , cnt = " + 
				cnt + "]" ; 
	}
	
	
}
