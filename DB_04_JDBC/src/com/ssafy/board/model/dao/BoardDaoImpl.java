package com.ssafy.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.util.DBUtil;

public class BoardDaoImpl implements BoardDao {
	//싱글턴으로 관리
	///////////////////////////////////////////////////
	private static BoardDao dao = new BoardDaoImpl();
	
	private BoardDaoImpl() {
	}	
	
	public static BoardDao getInstance() {
		return dao;
	}
	///////////////////////////////////////////////////
	
	//DB 연결을 뚫고 없애는 객체
	private DBUtil util = DBUtil.getInstance();
	
	
	
	@Override
	public List<Board> selectAll() {
		List<Board> list = new ArrayList<>();
		String sql = "SELECT * FROM board"; //게시글 전체를 조회하는 SQL문
		Connection conn = null;
		Statement stmt = null; 
		ResultSet rs = null;
		try {
			conn = util.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Board board = new Board(); //바구니 세팅
				board.setId(rs.getInt("id"));
				board.setWriter(rs.getString("writer"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setViewCnt(rs.getInt("view_cnt"));
				board.setRegDate(rs.getString("reg_date"));
				list.add(board);
			}
			
			//list 에 모든 게시글이 들어있다.!
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			util.close(rs, stmt, conn); // 마지막에 인자들 정리하기 (종료)
		}
		return list;
	}

	//게시글 한 개 조회
	@Override
	public Board selectOne(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
//		String sql = "SELECT * FROM board WHERE id="+id;
		String sql = "SELECT * FROM board WHERE id=?";
		Board board = new Board();
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);  // statement 객체 만듦
			pstmt.setInt(1, id);  // 인덱스처럼 1,2,3,... 가능
			
			rs = pstmt.executeQuery(); // SQL 실행& 쿼리 저장
			if(rs.next()) {
				board.setId(rs.getInt(1));
				board.setWriter(rs.getString(2));
				board.setTitle(rs.getString(3));
				board.setContent(rs.getString(4));
				board.setViewCnt(rs.getInt(5));
				board.setRegDate(rs.getString(6));
			}else {
				return null;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally { // 마지막에는
			util.close(rs, pstmt, conn);  // 종료
		}
		
		
		return board;
	}

	@Override
	public void insertBoard(Board board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		//StringBulider 이용하면 조금 더 편해
//		String sql = "INSERT INTO board (title, writer, content) VALUES('"+board.getTitle()+"'"..
		String sql = "INSERT INTO board (title, writer, content) VALUES(?,?,?)";
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			// ?에 대응하는 애들 set
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
//			pstmt.setString(4, board.getTitle());
//			pstmt.setString(5, board.getWriter());
//			pstmt.setString(6, board.getContent());
			
			//SQL문 완성!
			int result = pstmt.executeUpdate();
			System.out.println(result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			util.close(pstmt, conn);
		}
	}

	@Override
	public void deleteBoard(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM board WHERE id=");
		sb.append(id);
		
		String sql = "DELETE FROM board WHERE id=?";
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id); // 1번째 물음표에 id를 넣기
			int result = pstmt.executeUpdate();  // sql문 불러 오면서 삭제시키기
			System.out.println(result);
			
			//만약에 반환값이 result 가 0이면... 이미 없는거야~
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.close(pstmt, conn);
		}
		
		
	}

	@Override
	public void updateBoard(Board board) {
		// TODO Auto-generated method stub
		//일단은 마숙이나 내일 해결할 예정
	}

	@Override
	public void updateViewCnt(int id) {
		// TODO Auto-generated method stub
		//일단은 마숙이나 내일 해결할 예정
	}

}
