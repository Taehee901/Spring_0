package yedam.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import yedam.service.BookVO;

@Mapper
public interface BookMapper {
	//전체조회
	List<BookVO> bookList(BookVO bookVO);
	//단건조회
	BookVO bookDetail(Long bookNo);
	//등록
	int insertBook(BookVO bookVO);
	//삭제
	int bookRemove(Long bookNo);
	//대출현황
	List<BookVO> bookJoin(BookVO bookVO);
	Long selectBookNextVal();
}
