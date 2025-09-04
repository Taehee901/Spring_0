package com.example.demo.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class UserVO {
	  private Long id;
	  private String loginId;
	  private String password;
	  private String  fullName;
	  private String  deptName;
	  
	  private List<RoleVO> roles;

//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		List<GrantedAuthority> list = new ArrayList<>();
//		roles.forEach(role-> list.add(new SimpleGrantedAuthority(role.getRoleName())));
//		return list;
//	}
//	//시큐리티가 로그인 체크
//	@Override
//	public String getUsername() {
//		return loginId;
//	}
}
