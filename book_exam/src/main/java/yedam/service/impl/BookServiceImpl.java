package yedam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yedam.service.BookService;
import yedam.service.BookVO;

@Service
public class BookServiceImpl implements BookService {

	@Autowired BookMapper bookMapper;
	
	@Override
	public List<BookVO> selectBook() {
		return bookMapper.selectBook();
	}

	@Override
	public int insertBook(BookVO bookVO) {
		return insertBook(bookVO);
	}

	@Override
	public List<BookVO> selectRent() {
		return bookMapper.selectRent();
	}

	@Override
	public BookVO selectDetail(Long bookNo) {
		return bookMapper.selectDetail(bookNo);
	}

	@Override
	public int selectBookNo() {
		return bookMapper.selectBookNo();
	}
	
	@Override
	public int deleteBook(int bookNo) {
		return bookMapper.deleteBook(bookNo);
	}
}
