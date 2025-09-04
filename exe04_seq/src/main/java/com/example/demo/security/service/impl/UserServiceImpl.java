package com.example.demo.security.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.security.mapper.UserMapper;
import com.example.demo.security.service.CustomUserDetail;
import com.example.demo.security.service.UserService;
import com.example.demo.security.service.UserVO;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service //컨트롤러에서 서비스를 
public class UserServiceImpl implements UserService, UserDetailsService{//메서드를 가져와서 불러씀
	final UserMapper userMapper;
	@Override
	public UserVO getUser(String loginId) {
		return userMapper.getUser(loginId);
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO userVO = userMapper.getUser(username);
		if(userVO == null) {
			throw new UsernameNotFoundException("not found id");
		}
//		return userVO;
		return new CustomUserDetail(userVO);
	}

}
