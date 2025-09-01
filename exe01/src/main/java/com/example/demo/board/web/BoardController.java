package com.example.demo.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.service.BoardVO;


import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BoardController {
  @Autowired BoardMapper boardMapper;
  
  // boardList데이터를 꺼낼 때 사용할 이름
  @GetMapping("boardList")
  public String boardList(Model model) {
	  model.addAttribute("boardList",boardMapper.selectBoardList());
      return "boardList";
  }
  
}
