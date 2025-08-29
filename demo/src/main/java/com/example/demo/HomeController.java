package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller//라우터
public class HomeController {
	@Autowired
	Animal animal;//객체 x nullpointer에러
	
	@GetMapping("/")
	@ResponseBody
	public String home() {
		animal.sound();
		return "hello"; //JSON
	}
	
	@GetMapping("/main")
	public String main() {
		return "main";//templates/main.html
	}
	
}
