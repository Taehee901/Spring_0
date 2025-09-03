package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Component//빈등록
@Data
//@RequiredArgsConstructor 2.
public class SampleHotel {
	//1. 필드 (@Autowired)
	//2.생성자(@RequireArgConstructor + final)
	//3. setter(@Setter(onMethod_ = {@Autowired}))
//	@Autowired //1.
	@Setter(onMethod_ = {@Autowired})//3.
	Chef chef;
	
}
