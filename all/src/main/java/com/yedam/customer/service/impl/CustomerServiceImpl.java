package com.yedam.customer.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yedam.customer.service.CustomerService;
import com.yedam.customer.service.CustomerVO;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{

	@Resource(name="customerDAO") CustomerDAO customerDAO;
	
	@Override
	public CustomerVO selectCustomerDetail(Long id) {
		return customerDAO.selectCustomerDetail(id);
	}

}
