package yedam.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import yedam.service.BookService;
import yedam.service.BookVO;
@RequiredArgsConstructor

@Service
public class BookServiceImpl implements BookService {
	final BookMapper bookMapper;

	@Override
	public List<BookVO> bookList(BookVO bookVO) {
		return bookMapper.bookList(bookVO);
	}

	@Override
	public int insertBook(BookVO bookVO) {
		return bookMapper.insertBook(bookVO);
	}

	@Override
	public BookVO bookDetail(Long bookNo) {
		return bookMapper.bookDetail(bookNo);
	}

	@Override
	public int bookRemove(Long bookNo) {
		return bookMapper.bookRemove(bookNo);
	}

	@Override
	public List<BookVO> bookJoin(BookVO bookVO) {
		return bookMapper.bookJoin(bookVO);
	}

	@Override
	public Long selectBookNextVal() {
		return bookMapper.selectBookNextVal();
	}
}
