package com.example.demo.ex1;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class PersonController {
	@GetMapping("/person")
	public String showForm(PersonForm personForm) {
		return "form";
	}

	@PostMapping("/person")
	public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {//커맨드객체로 들어오는데 유효성 검사

		if (bindingResult.hasErrors()) {
			return "form";
		}

		return "redirect:/api/sample";//파일명이 일치해야한다.
	}
	
}
