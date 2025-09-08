package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
@Getter
//@Data
@Entity
public class Bread {
	public Bread() {};//기본생성자 필수
	@Builder
	public Bread(String breadName, String breadContent, int salary) {
		this.breadName = breadName;
	    this.breadContent = breadContent;
	    this.salary = salary;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)//기본키 값 자동생성하는 부분
	private Long id;
	@Column(length=50,nullable = true)
	private String breadName;
	@Column(length=100,nullable = false)
	private String breadContent;
	@Column(nullable = false)
	private int salary;
	
    public void update(String breadName, String breadContent,int salary) {
        this.breadName = breadName;
        this.breadContent = breadContent;
        this.salary = salary;
    }
}
