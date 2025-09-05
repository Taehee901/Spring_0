package com.example.demo.board.web;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.board.service.BoardService;
import com.example.demo.board.service.BoardVO;
import com.example.demo.common.Paging;

@RequestMapping("/board")
@Controller
public class BoardController {
//  @Autowired BoardMapper boardMapper;
   @Autowired BoardService boardService;
  // boardList데이터를 꺼낼 때 사용할 이름
  @GetMapping("/boardList")
  public String boardList(Model model,BoardVO boardVO,Paging paging) {
		//페이징관련
		paging.setPageUnit(5);//페이징건수
		paging.setTotalRecord(boardService.selectCount(boardVO));
		boardVO.setFirst(paging.getFirst());
		boardVO.setLast(paging.getLast());
	    model.addAttribute("boardList",boardService.selectBoardList(boardVO));
        return "board/boardList";
  }
  //단건조회
  @GetMapping("/board")
  public String board(Model model,@RequestParam Long bno) {
	  System.out.println(">>> bno=" + bno);
	  model.addAttribute("board",boardService.selectBno(bno));
	  return "board/board";
  }
  
  //등록 페이지로 이동
  @GetMapping("/board/register")
  public String boardpage(BoardVO boardVO) {
	  return "board/register";
  }
  @Value("${file.upload.dir}")//외부 설정 파일에서 값을 가져온다.(application.properties에서 설정해준 file.upload.dir에 해당되는 녀석)
  String UPLOAD_DIR; // UPLOAD_DIR이라는 이름의 문자열 변수 <- value 키 값(file.upload.dir)을 가지고 있음
  //등록처리
  @PostMapping("/board/register")
  //register의 파일 네임속성의 이름을 사용해줘야한다.
  public String boardRegister(BoardVO boardVO,MultipartFile file) throws IllegalStateException, IOException {
	  if(! file.isEmpty() && file.getSize() >0)
	  {
		  //첨부파일 업로드 - 게시판 파일여러건일 경우 파일테이블생성.,기존테이블에 파일명 파일 단건일 경우 
		  file.transferTo(new File(UPLOAD_DIR,file.getOriginalFilename()));
		  //파일명을 DB에 저장(없을 경우 null값 저장)
		  boardVO.setAttach(file.getOriginalFilename());   
	  }
	  boardService.insertBoard(boardVO);
	  return "redirect:/board/boardList"; //컨트롤러의 url을 적어주는 거임.
  }
  
	@GetMapping("/filedown/{filename}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String filename) throws MalformedURLException {
		// 파일 경로 설정
		Path filePath = Paths.get(UPLOAD_DIR).resolve(filename).normalize();

		// 파일을 Resource 로 로드
		Resource resource = new UrlResource(filePath.toUri());
		if (!resource.exists()) {
			return ResponseEntity.notFound().build();
		}

		// Content-Disposition 헤더에 다운로드용 파일명 지정
		String contentDisposition = "attachment; filename=\"" + resource.getFilename() + "\"";

		return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM) // 이진 파일
				.header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition).body(resource);
	}
  
  
  
  
  
// 1. 폼 기반 삭제요청 -> 
//유지보수,CSRF 공격 가능성,페이지가 리로드되기에 비추. RestAPI 방식(deleteMapping)사용 권장.
	@PostMapping("/boardList")
	public String delBoard(@RequestParam("bno") Long bno) {
		boardService.deleteBoard(bno);
		return "redirect:/board/boardList";
	}
}
