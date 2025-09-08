package com.example.demo.web;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PostsListResponseDto;

//import org.springframework.stereotype.Controller;

import com.example.demo.dto.PostsSaveRequestDto;
import com.example.demo.dto.PostsUpdateRequestDto;
import com.example.demo.service.PostsService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController // controllor와 차이?
public class PostsController {
	private final PostsService postsService; 
	//등록
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }
    //수정,vo 따로만들어도가능
    @PutMapping("/api/v1/posts/{id}")// id 외에는 json방식으로 들고옴
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }
    //페이징 조회
	@GetMapping("/api/v1/posts")
	public Page<PostsListResponseDto> index(Model model,
			@PageableDefault(page = 1, size = 3, sort = "id", direction = Direction.ASC) Pageable pagable) {
		return postsService.findAllPaging(pagable);
	}
	
}
