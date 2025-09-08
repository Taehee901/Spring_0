package com.example.demo.dto;

import com.example.demo.domain.Bread;
import com.example.demo.domain.Posts;

import lombok.Builder;
import lombok.Getter;

@Getter
public class breadDTO {
	private Long id;
	private String breadName;
	private String breadContent;
	private int salary;
	
	//단건조회
	public breadDTO() {};
	
	public breadDTO(Bread entity) {
		this.id= entity.getId();
	    this.breadName = entity.getBreadName();
	    this.breadContent = entity.getBreadContent();
	    this.salary = entity.getSalary();
	}
	//등록
	@Builder
	public breadDTO(String breadName, String breadContent, int salary) {
		this.breadName = breadName;
		this.breadContent = breadContent;
		this.salary = salary;
	}
	//엔티티로 변환
	public Bread toEntity() {
		return Bread.builder()
				.breadName(breadName)
				.breadContent(breadContent)
				.salary(salary)
				.build();
	}
}

