package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.ex1.UserVO;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.oas.models.media.MediaType;

@WebMvcTest(ExControllorTest.class)//사용 클래스이름 적어주면 됨
public class ExControllorTest {
	@Autowired
	private MockMvc mvc;

	@Test 
	public void testList() throws Exception { 
		
//		UserVO userVO = new UserVO (); 
//		userVO.setName("마이콜");
//	    userVO.setAge(20);
//	   
//	    String jsonStr = new ObjectMapper().writeValueAsString(userVO); 
	 
	    String result = mvc.perform(MockMvcRequestBuilders 
	                      .get("/api/rest2") //테스트 할 주소
	                      .param("age", "1") 
	                      .param("name", "kim"))
	                      .andExpect(status().isOk()) 
	                      .andReturn().getResponse().getContentAsString(); 
	    System.out.println(result);
	  
      }
	
	
	
//	@Test 
//	public void testList() throws Exception { 
////	    UserVO userVO = new UserVO(); 
////	    userVO.setName("마이콜"); 
////	    userVO.setAge(20); 
////	    String jsonStr = new ObjectMapper().writeValueAsString(userVO); //리퀘스트 바디가 아니라서 필요없음
//		String result = mvc.perform( get("/api/rest1")) 
//                 .param("age","1") 
//				 .param("name","kim")
//       			 .andExpect(status().isOk()) 
////                 .andExpect(content().contentType(MediaType.APPLICATION_JSON)) 
//       			 .andReturn().getResponse().getContentAsString();
//      System.out.println(result);
//	}
}
