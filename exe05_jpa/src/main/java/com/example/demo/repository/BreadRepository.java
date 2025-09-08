package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Bread;

public interface BreadRepository extends JpaRepository<Bread, Long>{
	//빵이름이 일치한 항목들을조회
	  List<Bread> findByBreadNameLike(String breadName);
}
