package com.ssafy.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.service.BoardService;

@Controller
public class BoardController {
	// Controller -> Service -> DAO -> MySQL
	
	private final BoardService boardService;  // 생성 singleton
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	
	//등록 페이지 요청
	@GetMapping("/writeform")
	public String writeform() {
		return "board/writeform";  // 가고 싶은 페이지 경로
	}
	
	@PostMapping("/write")
	public String write(@ModelAttribute Board board) {  // id는 auto increment라서 자동 증가됨
		boardService.writeBoard(board);
		return "redirect:list";
	}
	
	@GetMapping("/list")
	public String list(Model model) {  // 리스트를 담을 바구니가 필요함
		List<Board> list =  boardService.getBoardList();
		model.addAttribute("boardList", list);
		return "/board/list";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam("id") int id, Model model) {
		Board board = boardService.readBoard(id); // id에 맞는 board 들고 와서
		model.addAttribute("board", board); // model에 추가해주기
		return "/board/detail";
	}
	
	@GetMapping("/delete")  // GET요청으로 삭제하는 방법은 좋지 않음
	public String deleteByGet(@RequestParam("id") int id) {  // 특정 게시물 -> parameter id 사용
		boardService.removeBoard(id); // id에 맞는 게시글 삭제
		return "redirect:list";
	}
	
	@PostMapping("/delete")  // POST로 하자
	public String delete(@RequestParam("id") int id) {
		boardService.removeBoard(id); // id에 맞는 게시글 삭제
		return "redirect:list";
	}
	
	@GetMapping("/updateform")
	public String updateForm(@RequestParam("id") int id, Model model) {  // 게시글 읽어와야하니까 model 바구니 필요함 + 특정 게시물로 가야 하므로 id 가져옴
		model.addAttribute("board",boardService.getBoard(id));  // getBoard로 조회수 안올리고 조회
		return "/board/updateform";
	}
	
	@PostMapping("/update")  // updateform에서 받아온 요청 처리 -> POST
	public String update(@ModelAttribute Board board) {  // board 정보 받아옴 (ModelAttribute)
		boardService.modifyBoard(board);  // update에서의 board에는 id가 있음 (기존에 있는걸 바꾸니까)
		return "redirect:detail?id="+board.getId();
	}
	
	
	
}
