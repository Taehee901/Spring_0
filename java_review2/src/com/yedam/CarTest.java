package com.yedam;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class CarTest {
	//캡슐화 : 외부 접근 불가하게 막아주는거, getter,setter둘다x 외부접근불가
	@Test
	public void test3() {
		Car car1 = new Car("쏘렌토");
		//필드접근가능
		car1.setModel("테슬라"); //write
		System.out.println(car1.getModel());//read
	}
	
	
	
	
	@DisplayName("객체생성")
	@Test
	public void test2() {
		Car car1 = new Car("쏘렌토");
		Car car2 = new Car("카니발");
		assertEquals(car1, car2);
	}
	@DisplayName("싱글톤")
	@Test
	public void test() {
		Car car1 = Car.getInstance("쏘렌토");
		Car car2 = Car.getInstance("카니발");
		assertEquals(car1, car2);
	}
}
