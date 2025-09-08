package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Posts;
import com.example.demo.dto.PostsListResponseDto;
@Repository
//T: 테이블이름 ,2: 기본값 타입이 들어와야한다.(Long 단건 조회 및 삭제 할거니까..>
public interface PostRepository extends JpaRepository<Posts, Long>{
//	@Query("SELECT p FROM Posts p ORDER BY p.id DESC")
//	List<Posts> findAllDesc();

	@Query("SELECT p FROM Posts p ")
	Page<PostsListResponseDto> findAllPage(Pageable pageable);
}
