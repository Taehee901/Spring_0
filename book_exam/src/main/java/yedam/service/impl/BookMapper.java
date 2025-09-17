package yedam.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import yedam.service.BookVO;

@Mapper
public interface BookMapper {
	// 전체조회
	List<BookVO> selectBook();
	
	// 단건조회
	BookVO selectDetail(Long bookNo);
	
	// 대여조회
	List<BookVO> selectRent();
	
	// 등록
	int insertBook(BookVO bookVO);
	
	//도서번호 조회
	int selectBookNo();
	
	//도서삭제
	int deleteBook(int bookNo);
}
