package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class DITest {
	@Autowired TV tv;//컴포넌트를 꺼내쓰는거,인터페이스의 자식객체를 찾아서
	@Autowired SampleHotel hotel;
	//	@Test
	public void test() {
//		TV tv = new SamsungTv();
		//객체 주입방법
		tv.powerOn();
		tv.volumeUp();
	}
	//@Test
	public void hotel_test() {
		System.out.println(hotel.getChef());
	}
}
