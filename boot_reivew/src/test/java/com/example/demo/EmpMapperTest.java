package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.mapper.EmpMapper;

@SpringBootTest
public class EmpMapperTest {

	@Autowired EmpMapper empMapper;
	
	@Test
	public void 전체조회() {
		Map<String,Object> map = new HashMap<>();
		map.put("departmentId",30);
		map.put("salary",1000);
		//null => 전체 조회
		empMapper.selectAll(map).forEach(System.out::println);
	}
}
