package yedam.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import yedam.service.BookService;
import yedam.service.BookVO;

@Controller
public class BookController {
	@Autowired BookService bookService;
	@GetMapping("/bookList")
	public String bookList(Model model,BookVO bookVO){
		model.addAttribute("bookList",bookService.bookList(bookVO));
		return "list";
	}
	//등록폼
	@GetMapping("/bookAdd")
	public String bookAdd(Model model) {
		model.addAttribute("bookAdd",bookService.selectBookNextVal());
		return "regist";
	}
	//등록
	@PostMapping("/bookAdd")
	public String bookAdd(Model model, BookVO bookVO) {
		int result = bookService.insertBook(bookVO);
		return "redirect:/bookList";
	}
	@GetMapping("/book")
	public String book(Model model,@RequestParam Long bookNo) {
		model.addAttribute("book",bookService.bookDetail(bookNo));
		return "boardDetail";
	}
	
	@GetMapping("/bookJoin")
	public String bookJoin(Model model,BookVO bookVO) {
		model.addAttribute("bookJoin",bookService.bookJoin(bookVO));
		return "joinList";
	}
	
	@DeleteMapping("/bookRemove/{bookNo}")
	public String bookRemove(Model model,@PathVariable Long bookNo) {
		bookService.bookRemove(bookNo);
		return "/list";
	}
	@GetMapping("/")
	public String book() {
		return "index";
	}
}
