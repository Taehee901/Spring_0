package com.yedam.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.yedam.collect.EmpVO;

//class NameComp implements Comparator<EmpVO>{
//
//	@Override
//	public int compare(EmpVO o1, EmpVO o2) {
//		return o1.getDept() - o2.getDept();
//	}
//}
public class LambdaTest  {

	@Test
	public void test() {
		List<EmpVO> list = Arrays.asList(
							new EmpVO(100,"홍길동",10),new EmpVO(107,"김기자",50),
							new EmpVO(102,"나가자",20),new EmpVO(103,"최길동",30)
				);
		//익명클래스 겍체생성
//		list.sort(new Comparator<EmpVO>() {
//			//숫자가 클 경우 오름차순,아닐경우 내림차순
//			@Override
//			public int compare(EmpVO o1, EmpVO o2) {
//				return o2.getEmpno() - o1.getEmpno();
//			}
//		//람다방식
//		list.sort((EmpVO o1, EmpVO o2)->  o2.getEmpno() - o1.getEmpno());//익명클래스->람다식
//		System.out.println(list);
		//람다방식(이름순)
		//익명클래스->람다식(추상메서드가 하나인 경우)
		list.sort((EmpVO o1, EmpVO o2)->  o2.getEname().compareTo(o1.getEname()));
		System.out.println(list);
	}
}
