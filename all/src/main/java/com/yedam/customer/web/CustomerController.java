package com.yedam.customer.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.customer.service.CustomerService;
import com.yedam.customer.service.CustomerVO;

@RequestMapping("/customer")
@Controller
public class CustomerController {

	@Resource(name="customerService")
	CustomerService customerService;
	@GetMapping("/get.do")//localhost/egov/customer/get.do?id=1
	@ResponseBody
	public CustomerVO selectOne(@RequestParam("id") Long id) {
		return customerService.selectCustomerDetail(id);
	}
}
