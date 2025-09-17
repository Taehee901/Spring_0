package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository //마이바티스의 메퍼와 동일한 역할,메서드 다 넣어줌
//테이블 이름과 테이블 기본키 타입을 넣어주면 된다.,기본 crud 제공
public interface MemberRepository extends JpaRepository<Member, Long>{

	//이름 검색 메서드,단건 Member
	List<Member> findByname(String name);
}
