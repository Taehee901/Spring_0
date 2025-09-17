package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class SoneySpeaker implements Speaker {

	@Override
	public void volumeUp() {
		System.out.println("소니 불륨업");
	}

	@Override
	public void volumeDown() {
		System.out.println("소니 불륨다운");
	}

}
