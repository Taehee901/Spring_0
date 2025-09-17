package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@SpringBootTest
public class MemberEntityTest {

	//등록 수정 삭제 다 가능
	@Autowired EntityManager em;
	
	@Commit
	@Transactional
	@Test
	public void 회원_저장() {
		Member member = new Member();
		member.setName("홍길동");
		em.persist(member);//있으면 등록 없으면 수정
	}
}
