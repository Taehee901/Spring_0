package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.domain.Customer;
import com.example.demo.repository.CustomerRepository;

@SpringBootTest
public class CustomerRepositoryTest {

	@Autowired CustomerRepository customerTepository;
	
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
	public void delete() {
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
	@Test
	public void findByPhone() {
		customerTepository.findByPhone("1").forEach(System.out::println);
	}
}
