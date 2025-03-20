package com.ssafy.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.model.dto.Board;

public class JdbcTest {

	public JdbcTest() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
//			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		JdbcTest db = new JdbcTest();
		
		
		// Board 출력해보기
		for(Board board : db.selectAll()) {
			System.out.println(board);
		}

	}

	// 전체 게시글 조회
	private List<Board> selectAll() {
		List<Board> list = new ArrayList<>();
		///////////////////////////////////////////
		// DB 연결통로를 뚫음
		try {
			// SQL 연결해 DB 불러오기
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafy_board?serverTimezone=UTC",
					"root", "ssafy");  // (URL,ID,PW)
			
			// statement 객체 만듦
			Statement stmt = conn.createStatement();
			
			String sql = "SELECT * FROM board"; //게시글 전체를 조회하는 SQL문을 string으로 작성
			
			ResultSet rs = stmt.executeQuery(sql);  // SQL 문 실행하고 결과 반환
			//데이터가 몇개 있는지 몰라!
			
			while(rs.next()) {  // 다음 커서로 한칸씩 이동 (다 채우면 끝남)
				Board board = new Board(); //바구니 세팅
				board.setId(rs.getInt("id"));  // 각 row에 대한 데이터 추출
				board.setWriter(rs.getString("writer"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setViewCnt(rs.getInt("view_cnt"));
				board.setRegDate(rs.getString("reg_date"));
				
				list.add(board);  // board에 옮기기
			}//내용채우기
			
			// 역순으로 DB끊기
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
