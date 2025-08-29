package com.yedam.inter;
//V5
/*
 * 다형성
 * 부모타입의 참조변수가 자식객체 참조.
 * 참조하는 자식객체의 메서드를 호출 -> 실행결과 다르게 보임
 * **/
import org.junit.jupiter.api.Test;

public class AnimalTest {

	@Test
	public void test() {
		//다형성 Cat cat = new Cat => Dog dog = new Dog(x)
		Animal animal = new Cat();
		animal.sound();
	}
}
