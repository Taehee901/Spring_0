package com.yedam.collect;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ListVOTest {
	@Test
	public void test2() {
		DeptVO dept = DeptVO.builder().dname("aaa").build();
		DeptVO dept2 = DeptVO.builder().deptno(10).dname("bbb").build();
	}
	
	
	@Test
	public void test1() {
		List<EmpVO> list = new ArrayList<>();
		list.add(new EmpVO(100,"홍길동"));//empno,ename,dept
		list.add(new EmpVO(101,"홍길순"));
		list.add(new EmpVO(102,"홍길자"));
		
		//이름만 출력
//		list.forEach(null);
//		for(:)
		for(int i = 0;i<list.size();i++) {
			System.out.println(list.get(i).getEname());
		}
	}
}
