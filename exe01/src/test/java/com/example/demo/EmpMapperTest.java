package com.example.demo;

import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.emp.mapper.EmpMapper;
import com.example.demo.emp.mapper.EmpVO;

@SpringBootTest
public class EmpMapperTest {
@Autowired EmpMapper empMaPeer;
@DisplayName("전체조회")
@Test
public void selectEmp() {
	//키값
//	empMaPeer.selectEmp().forEach(emp -> System.out.println(emp.get("FRIST_NAME")));
//	empMaPeer.selectEmp().forEach(emp -> System.out.println(emp.get("firstName")));
	empMaPeer.selectEmp().forEach(emp -> System.out.println(emp.getFirstName()));
 }

@DisplayName("단건조회")
@Test
public void selectEmpById() {
	EmpVO empVO = empMaPeer.selectEmpById(100L);
	System.out.println(empVO.getFirstName());
}
@DisplayName("등록")
@Test
public void insertEmp() {
//	EmpVO empVO = new EmpVO();
	EmpVO empVO = EmpVO.builder()
			      .employeeId(401L)
			      .email("aaa_ab")
			      .lastName("길순")
			      .jobId("IT_PROG")
			      .hireDate(new Date())
			      .build();
			      
//	empVO.setEmail(null);
	int result = empMaPeer.insertEmp(empVO);
	System.out.println(result + " 건이 처리됨");
}
}
