package com.example.demo.dto;

import com.example.demo.domain.Posts;

import lombok.Builder;

//등록,ctrl+shift+o->임포트
public class PostsSaveRequestDto {
	private String title;
	private String content;
	private String author;
	
	@Builder
	public PostsSaveRequestDto(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}
	
	
	//엔티티로 변환
	public Posts toEntity() {
		return Posts.builder()
				.title(title)
				.content(content)
				.author(author)
				.build();
				
	}
}
