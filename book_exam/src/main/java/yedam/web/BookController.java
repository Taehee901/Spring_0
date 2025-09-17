package yedam.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import yedam.service.BookService;
import yedam.service.BookVO;

@Controller
public class BookController {
	@Autowired
	BookService bookService;

	// 등록페이지로 이동
	@GetMapping("/")
	public String home(BookVO bokVO) {
		return "/index";
	}

	
	// 전체조회
	@GetMapping("/list")
	public String BookList(Model model, BookVO bookVO) {
		model.addAttribute("bookList", bookService.selectBook());
		return "/list";
	}

	// 단건조회
	@GetMapping("/detail")
	public String BookDetail(Model model, @RequestParam("bookNo") Long bookNo) {
		model.addAttribute("bookDetail", bookService.selectDetail(bookNo));
		return "/detail";
	}

	// 대여현황조회
	@GetMapping("/rent")
	public String RentList(Model model, BookVO bookVO) {
		model.addAttribute("rentList", bookService.selectRent());
		return "/rent";
	}

	// 등록페이지로 이동
	@GetMapping("/regist")
	public String boardpage(BookVO bokVO, Model model) {
		model.addAttribute("bookNo", bookService.selectBookNo());
		return "/regist";
	}

	// 등록
	@PostMapping("/regist")
	public String boardRegister(BookVO bookVO, RedirectAttributes ra) {
		bookService.insertBook(bookVO);
		ra.addFlashAttribute("result", "등록되었습니다.");
		return "redirect:/list";
	}
	
	// 등록
	@GetMapping("/delete")
	public String boardRegister(@RequestParam("bookNo") int bookNo, RedirectAttributes ra) {
		bookService.deleteBook(bookNo);
		ra.addFlashAttribute("result", "삭제되었습니다.");
		return "redirect:/list";
	}	
}
