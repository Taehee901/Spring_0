package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Customer{
	//생성자 추가(source -> 
	public Customer() {};//기본생성자
	public Customer(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}
	
	@Id // 기본키 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private	Long id;
	@Column(length=20,nullable=false)//not null , 기본값으로 설정(아무것도 안넣으면)
	private	String	name;//
	@Column(length=20,nullable=false,unique	=true)
	private	String	phone;
}			