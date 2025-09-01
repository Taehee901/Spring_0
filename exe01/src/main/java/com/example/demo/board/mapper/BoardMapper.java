package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.board.service.BoardVO;

@Mapper
public interface BoardMapper {
	//전체조회
	List<BoardVO> selectBoardList() ;
}
