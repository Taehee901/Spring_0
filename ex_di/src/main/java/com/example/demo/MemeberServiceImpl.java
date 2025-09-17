package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class MemeberServiceImpl {
	//beforlog먼저 실행됨
	@PrintExecutionTime
	public void insert() {
		for(int i=0;i<1000000;i++)
		System.out.println("등록");
	}
}
