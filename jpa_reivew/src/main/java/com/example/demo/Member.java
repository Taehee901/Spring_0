package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private int age;
	//컬럼 추가
	private String school;
	
	//team_id 들어옴
    @ManyToOne                // N:1 관계
    @JoinColumn(name = "team_id") // FK 컬럼명
    private Team team;
}
