package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.annotation.Commit;

import jakarta.transaction.Transactional;

@SpringBootTest
public class MenberRepositoryTest {
	@Autowired MemberRepository memberRepository;
	@Autowired TeamRepository teamRepository;
	//테이블 데이터 남게 하고 싶으면 commit,Transactional
	@Commit 
	@Transactional
	//@Test //자동롤백
	public void 등록() {
		//팀등록
		Team team = new Team();
		team.setName("개발팀");
		teamRepository.save(team);
		
		//멤버등록
		Member member = new Member();
		member.setName("김유신");
		member.setAge(20);
		member.setSchool("MIT");
		member.setTeam(team);
		//crud 등 다 들어옴 등록 : save
//		memberRepository.save(member);
//		team.getMembers().add
		//멤버등록2
		Member member2 = new Member();
		member2.setName("이순신");
		member2.setAge(20);
		member2.setSchool("MIT");
		member2.setTeam(team);
		//crud 등 다 들어옴 등록 : save
		memberRepository.save(member2);
		
	}
	//멤버 조회
	//@Test
	public void 멤버_조회() {
		Member member =  memberRepository.findById(1L).get();//한건조회
		System.out.println(member.getName());
		System.out.println(member.getTeam().getName());
	}
	
	//조회
//	@Test
	public void 팀_조회() {
		Team team = teamRepository.findById(1L).get();//Long 타입 1L
		System.out.println(team.getName());
		team.getMembers().forEach(mem -> System.out.println(""+mem.getName()));
		
	}
	//이름검색,메서드명을 보고 m 모든 컬럼/Member 클래스 파라미터 인수 값 or :name 
	@Query("select m from Member m where m.name = ?1 order by name asc")//jpl문법
//	@Query("select m from Member m where m.name = :name order by name asc")
	@Test
	public void 멤버이름_검색() {
		List<Member> list =  memberRepository.findByname("이순신");
		System.out.println(list.get(0).getName()); 
		
	}

}
