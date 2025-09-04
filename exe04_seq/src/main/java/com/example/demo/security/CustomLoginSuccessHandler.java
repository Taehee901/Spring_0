package com.example.demo.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.demo.security.service.CustomUserDetail;
import com.example.demo.security.service.UserVO;

//import com.example.demo.securing.service.CustomerUser;
//import com.example.demo.securing.service.UserDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, 
			                 HttpServletResponse response,
			                 Authentication auth) throws IOException, ServletException {//한사람이 여러롤가능,배열
		//단건조회
		//UserDTO dto = ((CustomerUser)auth.getPrincipal()).getUserDTO();
		UserVO dto = ((CustomUserDetail)auth.getPrincipal()).getUserVO();//형변환
		//session
		request.getSession().setAttribute("userid", dto.getId());
		request.getSession().setAttribute("deptName", dto.getDeptName());
		
		//username, role
		List<String> roleNames = new ArrayList<>();		
		auth.getAuthorities().forEach( authority -> {
			roleNames.add( authority.getAuthority());
		}  );		
		System.out.println("roleName:" + roleNames);
		
		if ( roleNames.contains("ROLE_ADMIN") ) {
			response.sendRedirect("/admin");
			return;
		} else if ( roleNames.contains("ROLE_USER") ) {
			response.sendRedirect("/hello");
			return;
		} 
		response.sendRedirect("/");//if..else if 해당되지 않은 경우
	}

}