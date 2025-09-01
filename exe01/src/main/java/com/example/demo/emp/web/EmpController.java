package com.example.demo.emp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.common.Paging;
import com.example.demo.emp.mapper.EmpMapper;
import com.example.demo.emp.service.EmpVO;


@Controller // 라우터 바인딩
public class EmpController {
	@Autowired EmpMapper empMapper; //new x, 객체(빈)가 주입됨
	
	@GetMapping("empList")//empList?page=2
	public String empList(Model model, EmpVO empVO, Paging paging) {
		//페이징관련
		paging.setPageUnit(5);//페이징건수
		paging.setTotalRecord(empMapper.selectCount(empVO));
		empVO.setFirst(paging.getFirst());
		empVO.setLast(paging.getLast());
		model.addAttribute("empList",empMapper.selectEmp(empVO));
		return "empList"; //empList.html
	}
	@GetMapping("emp") //localhost/emp?employeeId=100
	public String emp(Model model,Long employeeId) {
		model.addAttribute("emp",empMapper.selectEmpById(employeeId));
		return "emp"; //emp.html
		
	}
	
	
}
