package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

//표준
@Lazy //지연로딩
@Scope("singleton")//?
@Component
@AllArgsConstructor
//@RequiredArgsConstructor3.
public class SamsungTv implements TV {
	@Setter(onMethod_ =  {@Autowired} )//위치가 맨 위면 모든 필드의 세터가 들어감2.
//	@Autowired //존재x ->nullPointError발생 1.
	Speaker speaker;
	//하나만 쓸거다
//	final Speaker speaker;
//	Date date;
	
//	//스피커 초기화하는 생성자
//	public SamsungTv(Speaker speaker) {
//		this.speaker = speaker;
//	}
//	//setter메서드
//	public void setSpeaker(Speaker speaker) {
//		this.speaker = speaker;
//	}

	public void powerOn() {
		System.out.println("삼성 TV--전원 on");
	}
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
//		System.out.println("삼성 TV--볼륨 down");
		speaker.volumeDown();
	}
}
