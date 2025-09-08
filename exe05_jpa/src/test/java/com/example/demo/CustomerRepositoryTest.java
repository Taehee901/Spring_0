package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.domain.Address;
import com.example.demo.domain.Customer;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.SchoolRepository;
import com.example.demo.repository.StudentReposiotry;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest // = DataJapTest는 자동 DB rollback이며,springBootTest대신 @DataJpaTest사용가능
public class CustomerRepositoryTest {

	@Autowired CustomerRepository customerTepository;
	@Autowired AddressRepository addressRepository;
	
	//@Test
	public void list() {
		List<Customer> list = customerTepository.findAll();//전체조회
		list.forEach(System.out :: println);
	}
	//단건조회
	//@Test
	public void get() {
		Customer customer = customerTepository.findById(1L).get();
		System.out.println(customer);
	}
	//@Test
	public void delete() {//삭제 방법. 1.단건조회 -> 삭제 2.where조건에 id를 지정
		//단건조회
		Customer customer = customerTepository.findById(1L).get();
		//삭제
		customerTepository.delete(customer);
	}
	//@Test
	public void insert() {
		Customer customer = new Customer("kim","010-2222-3333");
		customerTepository.save(customer);
		customerTepository.findAll().forEach(System.out::println);
	}
	//@Test
	public void update() {
		//단건조회
		Customer customer = customerTepository.findById(1L).get();
		//이름변경후
		customer.setName("홍길동");//객체안 값 변경
	    //save
    	customerTepository.save(customer);
	    //단건조회 결과 출력
		customer = customerTepository.findById(1L).get();
		System.out.println(customer);
	}
	//검색
	//@Test
	public void findName() {
		customerTepository.findByNameLike("Ki%").forEach(System.out::println);//upper,rower
	}
	//@Test
	public void findByPhone() {
		customerTepository.findByPhone("1").forEach(System.out::println);
	}
	//일대일테스트(),커스터머가 오더
	//@Test
	public void 일대일테스트() {
		 //	given(준비)
		 Address addressEntity	= Address.builder().zipcode("04411").address("대구").build();	
		 addressRepository.save(addressEntity);
		 Customer	customerentity = Customer.builder()
				 .name("길동")
				 .phone("011")
				 .address(addressEntity)
				 .build();																																		
		 customerTepository.save(customerentity);
		 //when(실행)
		 Customer	customer = customerTepository.findById(1L).get();
		 log.info(customer.getName()+":"+customer.getAddress().getZipcode()+customer.getAddress().getAddress());
		 //then(검증)
		 assertEquals("04411",	customer.getAddress().getZipcode());
	}
	
}
