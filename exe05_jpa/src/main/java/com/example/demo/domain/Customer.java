package com.example.demo.domain;
//DB에 테이블을 생성
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity //@Entity붙어 있는 클래스를 찾은 후 테이블 자동생성
public class Customer{
	//생성자 추가(source -> 
	public Customer() {};//기본생성자 필수
	public Customer(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	
	@Id // 기본키 
	@GeneratedValue(strategy = GenerationType.AUTO)//기본키 값 자동생성하는 부분
	private	Long id;
	@Column(length=20,nullable=false)//not null , 기본값으로 설정(아무것도 안넣으면),컬럼 제약조건 지정하는 부분
	private	String	name;//
	@Column(length=20,nullable=false,unique	=true)
	private	String	phone;
}			