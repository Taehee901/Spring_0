package yedam.service;

import java.util.List;

public interface BookService {
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
	
	//도서 삭제
	int deleteBook(int bookNo);
}
