package com.ssafy.board.test;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dao.BoardDaoImpl;
import com.ssafy.board.model.dto.Board;

public class Test {
	public static void main(String[] args) {
		BoardDao dao = BoardDaoImpl.getInstance();
		
//		System.out.println(dao.selectOne(100));
		
		
		dao.insertBoard(new Board("이제는 곤란해", "양강사", "사실 안곤란해"));
//		for(int i= 1; i<30; i++) {
//		}
		
		dao.deleteBoard(2);
		
		
		
		
	}
}
