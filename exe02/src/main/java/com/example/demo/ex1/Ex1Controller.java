package com.example.demo.ex1;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j2;


@Log4j2
// /api/ex1 이런식으로
@RequestMapping("/api") 
@Controller
public class Ex1Controller {
	@GetMapping("/sample")
	public ModelAndView sample() {
		ModelAndView mv = new ModelAndView("sample");
		mv.addObject("today",new Date());
		return mv;
	}
	
	@GetMapping("/main") //templates/api/main.html
	public void main() {}
	//커맨드 객체(모든 파라미터)
	@GetMapping("/ex1")
	//받을 데이터 정해줌,url 메서드랑 같은 이름
//	public String ex1(@ModelAttribute("user") UserVO userVO,Model model) {
////		model.addAttribute("user",userVO); //model.addAttribute("user",mapper.select())
//		log.info(userVO);
//		return "sample";
//	}
	public String ex1(@ModelAttribute("user") UserVO userVO,Model model) {
	//model.addAttribute("user",userVO); //model.addAttribute("user",mapper.select())
	log.info(userVO);
	return "sample";
	}
	//다건,근데 배열로는 이방식보다 json,ajax쓰는게 나음 //userList[0].name userList[0].age 
	//인데스 배열객체									//userList[1].name userList[1].age 
	@GetMapping("/ex2")
	public String ex2(UserListVO list) {
		log.info(list);
		return "sample";
	}
	//request.getParameter() = @RequestParam, 원시데이터형(String,int)개별 하나씩
	//value: 파라미터 이름이 다를 경우,
	//integer null허용 require=false 파라미터가 필수값x,defaultValue 파라미터가 없거나 null일 경우 사용할 기본값
	@GetMapping("/ex3")
	public String ex3(@RequestParam String name,
			@RequestParam(value = "userage", required = false,defaultValue = "20") Integer age) {
		log.info(name + ":" + age);
		return "sample";
	}
	//@RequestParam Map<- 모든 파라미터 담아서 사용
	@GetMapping("/ex4")
	public String ex4(@RequestParam Map<String, Object> map) {
		log.info(map);
		return "sample";
	}
	// @PathVariable 데이터타입 변수이름(경로로 값을 포함해서 보낼때)
	@GetMapping("/ex5/{name}/{age}")//http://localhost/api/ex5/kim/20
	public String ex5(@PathVariable String name,@PathVariable int age) {
		log.info("path=" + name+":"+ age);
		return "sample";
	}
	//첨부파일
	@PostMapping("/ex6")
	public String ex6(UserVO vo,MultipartFile pic) {
		log.info(pic.getOriginalFilename());
		log.info(pic.getSize());
		log.info(vo);
		return "sample";
	}
}
