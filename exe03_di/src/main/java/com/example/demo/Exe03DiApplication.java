package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(ba) ->
public class Exe03DiApplication {

	public static void main(String[] args) {//제일먼저 시작하는 클래스
		SpringApplication.run(Exe03DiApplication.class, args);
	}

}
