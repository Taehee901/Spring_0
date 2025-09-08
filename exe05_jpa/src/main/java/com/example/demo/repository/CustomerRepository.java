package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Customer;

@Repository //얘는 JPA 마이바티스는 bin
public interface CustomerRepository extends JpaRepository<Customer,Long> {//JpaRepository crud 등 저장되어있다.<대상,기본키 타입>
	//쿼리만드는 부분
	//사용자 정의 -> 메소드 이름규칙기반으로 쿼리 생성
	List<Customer> findByNameLike(String name);
	//"" x -> mapper,jpqa,쿼리케이스
	@Query("select u from Customer u where u.phone like %?1% order by name desc")//변수 몇번째 값인지 알려줘야한다.
	List<Customer> findByPhone(String phone);//phone -> ?
	@Query("select u from Customer u where u.phone like %:phone% or name like %:name% order by name desc")//변수 몇번째 값인지 알려줘야한다.
	List<Customer> findByPhoneAndName(@Param("name") String phone,@Param("name") String name);
}
