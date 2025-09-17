package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
//어느 엔터티 제어? 타입?
public interface TeamRepository extends JpaRepository<Team, Long> {

}
