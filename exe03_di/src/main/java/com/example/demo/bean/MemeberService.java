package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemeberService {
	
    MemberMapper memberMapper;
	
    public void print() {
		System.out.println(memberMapper + "서비스 호출");
	}
}
