package yedam.service;

import java.util.List;

public interface BookService {
	List<BookVO> bookList(BookVO bookVO);
	//등록
	int insertBook(BookVO bookVO);
	//단건조회
	BookVO bookDetail(Long bookNo);
	//삭제
    int bookRemove(Long bookNo);
	List<BookVO> bookJoin(BookVO bookVO);
	Long selectBookNextVal();
}
