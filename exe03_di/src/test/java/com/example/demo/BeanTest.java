package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.bean.MemeberService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class BeanTest {
	@Autowired
	MemeberService memeberService;
	@Test
	public void test() {
//		log.info(memeberService);
		memeberService.print();
	}
}
