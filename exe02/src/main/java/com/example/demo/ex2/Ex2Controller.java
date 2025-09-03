package com.example.demo.ex2;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.ex1.UserVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import reactor.core.publisher.Mono;

@Tag(name = "회원관리",description = "게임사이트 회원 가입")//name:태그이름, 설명
@RequestMapping("/api")
@RestController //@Controller + @ResponseBody
public class Ex2Controller {
	@Tag(name = "회원관리 API")
	@Operation(summary = "회원조회")
	// UserVO 단건조회
	@GetMapping("/rest1")
	public UserVO rest1() {
		return new UserVO("홍길동",20,new Date(),Arrays.asList("게임","잠자기"));//server.select()
	}
	@Tag(name = "회원관리 API")
	@Operation(summary = "회원단건조회")
	//쿼리스트링으로 보냄,rest2에 값을 받아서 파라미터받아서 담고 json스트링으로 넘어감,
	//requestbody없는경우 일반 스트링방식,클라이언트가 데이터를 쿼리 파라미터(GET) 또는 폼 데이터(POST form)로 보낸다
	@GetMapping("/rest2")//query String
	public UserVO rest2(UserVO userVO) {
		return userVO;
	}
	//json 스트링은 get 방식은 x
	@PostMapping("/rest3")//json 스트링 {"name":"aaaa","age":10} ==> VO객체에 넣어줌 
	public UserVO rest3(@RequestBody UserVO userVO) {
		return userVO;
	}
	//서버끼리 통신
	@GetMapping("/rest4")
	public Map rest4() {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "https://jsonplaceholder.typicode.com/todos/1";
		return restTemplate.getForObject(uri, Map.class);
	}
	//비동기방식(웹클라이언트,block()을 붙이면 비동기->동기방식),반응형
	@GetMapping("/rest5")
	public String getPost() { 
		  WebClient webClient = WebClient.create(); 
		  String response = webClient.get() 
		        .uri("https://jsonplaceholder.typicode.com/posts/1") 
		        .retrieve() 
		        .bodyToMono(String.class).block(); 
		  return response; 
		}
}


