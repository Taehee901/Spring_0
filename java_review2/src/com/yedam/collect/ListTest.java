package com.yedam.collect;
/*
 * List
 * Set
 * Map
 * 
 * 
 * **/


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

//과제
//1.ArrayList와 LinkedList 차이점과언제사용하는지?

//import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class ListTest {
	@DisplayName("Map")
	@Test
	public void test3() {
		//검색(사원일 경우 key:사원 value:이름)
		Map<String,String> map = new HashMap<>();
		map.put("100", "홍길동");
		map.put("101", "김유신");
		
		map.get("100");//검색속도 map:1, list :n
		
	}
	
	//중복허용,검색속도 n
	@DisplayName("List")
	@Test
	public void test1() {
		List<String> list = new ArrayList<>();
		list.add("사과");
		list.add("바나나");
		list.add("사과");
		assertEquals(list.size(), 3);
		
		//중복값알아서 제거 후 값 넣어줌
		Set<String> set = new HashSet<>(list);
		assertEquals(set.size(), 3);
		
	}
	//중복비허용,ex 로또
	@DisplayName("set")
	@Test
	public void test2() {
		Set<String> list = new HashSet<>();
		list.add("사과");
		list.add("바나나");
		list.add("사과");
		assertEquals(list.size(), 3);
	}
}
