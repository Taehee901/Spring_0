package com.yedam;

/*
 * 클래스 = 설계도 : 속성(필드) + 행위(메서드)
 * 1. 클래스 선언
 * 2. 객체(인스턴스) 생성 -> 메모리영역 공간 할당,데이터지정할수있는
 * 3. 객체 사용
 * 
 * 캡슐화 : 외부접근 막고, setter/getter 접근 제어
 * 
 * 
 * */
public class Car {
	//각인스턴스마다배정
	//static: 클래스필드 = 모든 인스턴스 공유필드
	//static o -> 카니발
	//x -> 쏘렌토,카니발static
	  private String model;
//	  //값 변경 setter
	  public void setModel(String model) {
		  this.model = model;
	  }
	  //getter
	  public String getModel() {
		  return model;
	  }
	  
	  
		//생성자: 객체 생성 시 호출되는 메서드,필드초기화
		public Car(String model) {
			this.model = model;
		}
		
	// 1. 자기 자신을 저장할 정적 변수
	  private static Car instance;

	// 3. 유일한 객체 반환 (필요할 때 생성)
	public static Car getInstance(String model) {
		if (instance == null) {
			instance = new Car(model);
		}
		return instance;
	}

//	//생성자 : 인수가 없는 생성자가 x,생성자가 1있으면 기본생성자를 안넣어줌 
//	//사용이유? 객체생성 접근제어자 public,return 타입 사용x,클래스이름과동일
//	//인수 있는 생성자
//	public Car(String model) {
//		this.model = model;
//	}
//	//기본생성자
//	public Car() {}
	public void drive() {
		System.out.println(model+"운행");
	}
}
