package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DITest {
	@Autowired TV tv; //필드주입방법

	@Test
	public void test() {

//		TV tv = new LgTV();   //LgTV로 교체해보세요

		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();

	}
}