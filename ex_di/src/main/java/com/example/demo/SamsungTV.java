package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor // final만 붙은 생성자만 초기화
//@AllArgsConstructor //모든필드 초기화 -> 스피커를 초기화
@Component
public class SamsungTV implements TV{
//	@Autowired // 1.필드주입방법
	final Speaker speaker; //스피커만 초기화 하려면 final 붙이고 -> req
	int brand;
	
	
	@Override
	public void powerOn() {
		System.out.println("삼성 TV--전원 on");
	}
	@Override
	public void powerOff() {
		System.out.println("삼성 TV--전원 off");
	}
	@Override
	public void volumeUp() {
//		System.out.println("삼성 TV--볼륨 up");
		speaker.volumeUp();
	}
	@Override
	public void volumeDown() {
		System.out.println("삼성 TV--볼륨 down");
		speaker.volumeDown();
	}
}
