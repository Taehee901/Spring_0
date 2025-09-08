package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Posts;
import com.example.demo.dto.PostsListResponseDto;
import com.example.demo.dto.PostsSaveRequestDto;
import com.example.demo.dto.PostsUpdateRequestDto;
import com.example.demo.repository.PostRepository;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service //서비스등록
public class PostsService {
	//등록
    private final PostRepository postRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postRepository.save(requestDto.toEntity()).getId(); //등록된 시퀀스 id값 조회
    }
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postRepository.findById(id)//단건조회 -> 나머지는 DTO
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());
//        postRepository.save(posts); -> 이것도 가능하지만 위의 방식이 낭름

        return id;
    }
    //페이징조회
    public Page<PostsListResponseDto> findAllPaging(Pageable pageable) {
    	 return postRepository.findAllPage(pageable);
    }
}
