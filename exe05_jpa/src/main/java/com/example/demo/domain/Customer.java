package com.example.demo.domain;
//DB에 테이블을 생성
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
//@Data
@Entity //@Entity붙어 있는 클래스를 찾은 후 테이블 자동생성
public class Customer extends BaseTimeEntity{
	//생성자 추가(source -> 
	public Customer() {};//기본생성자 필수
	
	public Customer(String name,String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}
	
	
	@Builder
	public Customer(String name, String phone,Address address) {
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	
	@Id // 기본키 
	@GeneratedValue(strategy = GenerationType.AUTO)//기본키 값 자동생성하는 부분
	private	Long id;
	@Column(length=20,nullable=false)//not null , 기본값으로 설정(아무것도 안넣으면),컬럼 제약조건 지정하는 부분
	private	String	name;//
	@Column(length=20,nullable=false,unique	=true)
	private	String	phone;
	
	@OneToOne 
	@JoinColumn(name="address_id")
	Address address; // 1대 다 관계일 경우에는 List<Address>address
}			