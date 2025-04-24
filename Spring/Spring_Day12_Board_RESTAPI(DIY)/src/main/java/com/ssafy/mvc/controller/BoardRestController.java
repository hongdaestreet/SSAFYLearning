package com.ssafy.mvc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.dto.SearchCondition;
import com.ssafy.mvc.model.service.BoardService;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController  // 각 메서드가 RestBody 생략해도 JSON으로 응답할 수 있게 함
@RequestMapping("/api")  // 이 클래스의 모든 요청은 "/api" 경로로 시작함
@Tag(name = "Board RESTful API", description = "게시판 CRU를 할 수 있음")  // 설명
public class BoardRestController {

	// 서비스 의존성 주입
	private final BoardService boardService;

	// 생성자 주입 -> 자동으로 Bean 등록해줌
	public BoardRestController(BoardService boardService) {
		this.boardService = boardService;
	}

	//R 게시판 목록 조회 + 검색
	@GetMapping("/board")
	@Operation(summary="게시글 조회",description="조건에 따른 검색 수행")  // Swagger 문서용 메서드 설명
	public ResponseEntity<?> list(@ModelAttribute SearchCondition condition) {
		System.out.println(condition);
		List<Board> list = boardService.search(condition);  // 검색 조건에 맞는 게시글 리스트

		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);  // 결과없으면 204 No Content
		}
		return new ResponseEntity<List<Board>>(list, HttpStatus.OK);  // 결과있으면 list 반환
	}

	//R 게시글 상세 조회 (by id)
	@GetMapping("/board/{id}")
	public ResponseEntity<Board> detail(@PathVariable("id") int id) {
		Board board = boardService.readBoard(id);  // id에 해당하는 게시글 조회
		if (board != null) {
			return ResponseEntity.ok(board);  // 게시글 존재하면 객체 반환
		}
		// board가 null인 상황 -> URL 직접 입력해서 들어옴
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // 없으면 404 Not Found
	}

	//C 게시글 등록(Form 데이터로 받음)
	@PostMapping("/board")
	public ResponseEntity<Void> write(@ModelAttribute Board board) {
		System.out.println(board);  // ID가 채워지기 전 board 내용
		boardService.writeBoard(board); // 게시물 등록 (이후 이동 페이지)-> 메인 or 상세글
		System.out.println(board); // ID가 DB에서 자동으로 채워짐
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	//D 게시글 삭제
	@Hidden  // 기능을 화면에서 숨김
	@DeleteMapping("/board/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		boolean isDeleted = boardService.removeBoard(id);  // id인 게시물 삭제 시도
		if (isDeleted)
			return ResponseEntity.status(HttpStatus.OK).body("Board delete");  // 삭제되면 성공 표시
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed");  // 삭제 안되면 실패 표시
	}
	
	//U 게시글 수정 (JSON 형식)
	@PutMapping("/board/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Board board){
		board.setId(id);  // URL에서 받은 ID를 직접 객체에 세팅함
		boardService.modifyBoard(board);  // 게시물 수정
		// ID에 해당되는 보드가 없을 수도 있음
		// 데이터가 다 넘어오지 않음   
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	
	

}
