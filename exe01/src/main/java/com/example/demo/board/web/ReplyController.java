package com.example.demo.board.web;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.board.mapper.ReplyMapper;
import com.example.demo.board.service.ReplyVO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ReplyController {
	@Autowired ReplyMapper replyMapper;
// 등록
	@PostMapping("/reply")
	//json일 경우 content-type으로 확인 가능,html의 url,메서드 동일,form일 경우 reqbody는 필요x
	public int insert(@RequestBody ReplyVO vo) {
		int result  = replyMapper.insert(vo);
		return result;
	}
// 수정
	@PutMapping("/reply/{rno}")
	public int update(@RequestBody ReplyVO vo) {
	    return replyMapper.update(vo);
	}
//삭제
	@DeleteMapping("/reply/{rno}")
	public int delete(@PathVariable Long rno) {
		int result = replyMapper.delete(rno);
		return result;
	}
//전체조회
	@GetMapping("/board/{bno}/reply")
	public List<ReplyVO> list(ReplyVO replyVO) {
		replyVO.setFirst(1);
		replyVO.setLast(100);
		return replyMapper.getList(replyVO);
	}
//단건조회,삭제랑 유사 메서드만 다름
	@GetMapping("/reply/{rno}")
	public String get( ) {
		return "";
	}
}
