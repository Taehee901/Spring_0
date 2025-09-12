package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.example.demo.mapper")
@SpringBootApplication
public class BootReivewApplication {
	//메퍼를 다 읽어들여서 , 현재 패키지 기준으로 서비스 인터페이스를 만들어줌 , 지정경로 달라지면 .**.
	public static void main(String[] args) {
		SpringApplication.run(BootReivewApplication.class, args);
	}

}
