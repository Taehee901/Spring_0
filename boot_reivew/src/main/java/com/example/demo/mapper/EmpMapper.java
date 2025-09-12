package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper //인터페이스로 프록시 DAO 객체(DAO)생성해서 Bean(빈)으로 등록.
public interface EmpMapper {
	List<Map> selectAll(Map map);
}
