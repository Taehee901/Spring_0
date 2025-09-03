package com.example.demo.ex1;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "회원정보")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
	
	@Schema(description = "회원이름")
//	@JsonProperty(value = "userName") //받을때는 유저네임으로 받아서 응답을 보내주는거고,보낼때는 name으로 가능 -> name이라는 필드를 사용하고, 외부(JSON)에서는 userName이라는 이름으로 매핑
	 String name;
	@Schema(description = "나이")
	//@JsonIgnore //숨김기능
	 int age;
	@Schema(description = "가입일자")
	 // / -> - 날짜형식으로 포맷 지정할때
	 @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	 //json포맷 
	 @JsonFormat(pattern = "yyyy-MM")
	 private Date wdate;
	@Schema(description = "관심분야")
	 //다건일 경우 = String[] hobby
	 List<String> hobby; // = string[]
}
