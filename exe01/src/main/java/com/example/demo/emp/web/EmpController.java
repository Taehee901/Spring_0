package com.example.demo.emp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.emp.mapper.EmpMapper;


@Controller // 라우터 바인딩
public class EmpController {
	@Autowired EmpMapper empMapper; //new x, 객체(빈)가 주입됨
	
	@GetMapping("empList")
	public String empList(Model model) {
		model.addAttribute("empList",empMapper.selectEmp());
		return "empList"; //empList.html
	}
	
	
}
