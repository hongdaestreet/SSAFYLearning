package com.ssafy.mvc.model.dao;

import java.util.List;

import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.dto.SearchCondition;

public interface BoardDao {
	// 전체 게시글을 조회
	public List<Board> selectAll();

	// 게시글 조회
	public Board selectOne(int id);

	// 게시글 등록
	public void insertBoard(Board board);

	// 게시글 삭제
	public int deleteBoard(int id);

	// 게시글 수정
	public void updateBoard(Board board);

	// 조회수 증가
	public void updateViewCnt(int id);
	
	// 검색
	public List<Board> search(SearchCondition condition);

}
