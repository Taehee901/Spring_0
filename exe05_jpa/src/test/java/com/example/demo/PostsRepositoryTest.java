package com.example.demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Posts;
import com.example.demo.repository.PostRepository;

@SpringBootTest
public class PostsRepositoryTest {
 @Autowired PostRepository postsRepository;
 //기존게 다 지워지는게 아니라 방슴 인설트한 것만 롤백
 //DB데이터 유지
// @Transactional
// @Rollback(true)
 
 //모든 테스트가 끝난 후에 실행.
// @AfterAll // 테스트 실행 후 다 지운 채 나옴
//	public void tearDown() throws Exception {
//		postsRepository.deleteAll(); //데이터 다 지울 때 사용
//	}
 @Test
 public void insert() {
	 // new posts "" 2.builder
//	 Posts posts = new Posts("","","");
	 //생성자에 필드걸면 초기화 해서 빌드에서 생성
	 Posts posts = Posts.builder().author("김유미").title("포스트제목").content("오늘도 열심히!!.").build();
	 postsRepository.save(posts);
 }
}
