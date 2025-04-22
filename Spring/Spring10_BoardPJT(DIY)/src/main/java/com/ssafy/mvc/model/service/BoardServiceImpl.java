package com.ssafy.mvc.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.mvc.model.dao.BoardDao;
import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.dto.SearchCondition;

@Service
public class BoardServiceImpl implements BoardService{

	private final BoardDao boardDao;
	
	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	@Override
	public List<Board> getBoardList() {
		System.out.println("게시글 전체 목록");
		return boardDao.selectAll();
	}

	@Transactional
	@Override
	public Board readBoard(int id) {
		System.out.println("게시글 상세 조회");
		boardDao.updateViewCnt(id);
		return boardDao.selectOne(id);
	}
	
	@Transactional  // 트랜잭션 적용 -> 
	@Override
	public void writeBoard(Board board) {
		System.out.println("게시글 작성");
		boardDao.insertBoard(board);
//		boardDao.insertBoard(board);  // 연속 2개 해도 글 번호만 다른 똑같은 글이 등록됨
	}
	
	@Transactional
	@Override
	public void removeBoard(int id) {
		System.out.println("게시글 삭제");
		boardDao.deleteBoard(id);
	}
	
	@Transactional
	@Override
	public void modifyBoard(Board board) {
		System.out.println("게시글 수정");
		boardDao.updateBoard(board);
		
	}

	@Override
	public Board getBoard(int id) {
		return boardDao.selectOne(id);
	}
	
	// 검색 조건에 맞게 검색
	@Override
	public List<Board> search(SearchCondition condition) {
		String word = condition.getWord();
		condition.setWord("%"+word+"%");  // LIKE로 포함된 단어를 검색해야 하므로 양 끝에 %붙여줌
		return boardDao.search(condition);
	}

}
