package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class UserController {
//void -> url 페이지를 찾아감 -> from.html,페이지와 url이 다르면 String return 같으면 생략가능
	@GetMapping("/form")
	public void userForm(UserVO user) {
		
	}
	//등록 버튼 클릭 시 -> 호출
	@PostMapping("/form")
	public String user(@Valid UserVO user,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "form";
		}
		//insert 호출 
		return "redirect:/"; //
	}
}
