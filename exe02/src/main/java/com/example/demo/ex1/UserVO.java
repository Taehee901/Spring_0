package com.example.demo.ex1;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
	@JsonProperty(value = "userName")
	 String name;
	 @JsonIgnore
	 int age;
	 // / -> - 날짜형식으로 포맷 지정할때
	 @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	 //json포맷 
	 @JsonFormat(pattern = "yyyy-MM")
	 private Date wdate;
	 //다건일 경우 = String[] hobby
	 List<String> hobby; // = string[]
}
