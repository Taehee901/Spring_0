package com.example.demo;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class SampleController {
	@GetMapping("/")
	public String sample() {
		return "sample";//폴더명/파일명
	}
	//질의문자열 -> 커맨드 객체
		@GetMapping("/ex1")
		public String ex1(@ModelAttribute("user") UserVO userVO) {
			log.info(userVO);
			return "sample";
		}

		//JSON 문자열 -> 커맨드 객체.json이라 파싱이 필요 @RequestBody get방식이 안됨 -> post,put delete만 가능. get은 쿼리스트링만 가능
		@PostMapping("/ex2")
		public String ex2(@RequestBody UserVO userVO) {
			log.info(userVO);
			return "sample";
		}

		//@RequestParam 원시타입(String, int...) 파라미터
		@GetMapping("/ex3")
		public String ex3(@RequestParam String name,
				              @RequestParam(value = "userage", required = false, defaultValue = "20") Integer age) {
			log.info(name +":" + age);
			return "sample";
		}

		// @RequestParam Map 
		@GetMapping("/ex4")
		public String ex4(@RequestParam Map<String, Object> map) {
			log.info(map);
			log.info(map.get("name"));//키만 적어주면 키에 해당되는 녀석만 보인다.
			return "sample";
		}

	  // @PathVariable -> http://localhost/ex5/김유미/20
		@GetMapping("/ex5/{name}/{age}")  // http://localhost/api/ex5/kim/29
		public String ex5(@PathVariable String name,
				              @PathVariable int age) {
			log.info("path=" + name + ":" + age );
			return "sample";
		}

		//첨부파일
		@PostMapping("/ex6")
		public String ex6(UserVO vo, MultipartFile pic) {
			log.info(pic.getOriginalFilename());
			log.info(pic.getSize());
			log.info(vo);
			return "sample";
		}
}
