//package com.yedam.lambda;
//
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//
//import com.yedam.collect.EmpVO;
//
//class NameComp implements Comparator<EmpVO>{
//
//	@Override
//	public int compare(EmpVO o1, EmpVO o2) {
//		return o1.getDept() - o2.getDept();
//	}
//}
//public class LambdaTest2  {
//
//	@Test
//	public void test() {
//		List<EmpVO> list = Arrays.asList(
//							new EmpVO(100,"홍길동",10),new EmpVO(101,"김기자",50),
//							new EmpVO(102,"나가자",20),new EmpVO(103,"최길동",30)
//				);
//		list.sort(new NameComp());
//		System.out.println(list);
//	}
////	Collection.
//}
