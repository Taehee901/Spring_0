package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	//646p 비밀번호 암호화,암호화x 647p
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new CustomLoginSuccessHandler();//인터페이스 구현클래스를 불러옴
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/", "/home").permitAll()//모두 접근가능
				.requestMatchers("/admin").hasRole("ADMIN")//롤을 찾아가는 녀석
				.anyRequest().authenticated() // "/","/home"이 외에는 인증이가능해야 페이지에 접근이 허용된다.
			)
			//스트림 map,forEach 
			//람다식으로 : 
			.formLogin((form) -> form
				.loginPage("/login")
				.permitAll()
				.successHandler(authenticationSuccessHandler())
			)
//			.formLogin().loginPage("/login")
//			       .successHandler(authenticationSuccessHandler())
//			       .and()
			.logout((logout) -> logout.permitAll());
      	    http.csrf((csrf->csrf.disable()));
		    http.exceptionHandling(ex -> ex.accessDeniedHandler(accessDeniedHandler()));//403에러나면

		return http.build();
	}
	//객체등록
	@Bean 
	AccessDeniedHandler accessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
 
	//임의정보
	//@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user")
				.password("1234")
				.roles("USER")
				.build();
		UserDetails admin =
				 User.withDefaultPasswordEncoder()
					.username("admin")
					.password("1234")
					.roles("ADMIN","INSA") //한명이 여러 룰 가질 수 있다.
					.build();
	
//	//DB에서 사용

		return new InMemoryUserDetailsManager(user,admin);
	}
}
