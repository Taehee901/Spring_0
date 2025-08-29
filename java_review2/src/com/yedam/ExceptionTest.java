package com.yedam;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Scanner;
import org.junit.jupiter.api.Test;

class Score {
	//throws : 예외처리를 하지 않고 호출한 메서드로 예외 던짐
	public void input() throws Exception {
		Scanner scan = new Scanner(System.in);
		int n1 = scan.nextInt();
		int n2 = scan.nextInt();
		int n3 = total(n1, n2);
		System.out.println("result="+n3);
	}
	public int total(int n1,int n2) throws Exception {
		//업무규칙에 위배되는 경우 예외 발생
		if(n1 <0 || n2<0) {
			throw new Exception("음수 입력");
		}
		int result = n1 + n2;
		return result;
	}
}

public class ExceptionTest {
	@Test
	//JVM이 처리,
	public void test() {
		//객체 생성
		Score score = new Score();
		//input 메서드 호출(실행)
		try {
			score.input();//참조메서드input
		} catch (Exception e) {
			System.out.println("the end");// throws일 경우에는 에러를 위로 던지기에 실행되지 x 위로 예외를 던짐
		}
	}
}
