package com.example.demo.common.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//클래스를 어드바이스로 쓸거 지정
@Aspect
@Component
public class LogBeforeAdvice {
	//com.example- 패키지의 클래스명이 impl로 끝나는 메서드 아무거나 상관없다. 만약 *Impl.get이 붙으면 get만 시작하게됨
   @Pointcut("execution(* com.example..*Impl.*(..))") 
   public void  allpointcut() {} //포인터컷은 메서드의 이름으로 지정한다.
	
	@Before("allpointcut()") //서비스실행전 
	//로그찍어주는 메서드 
	public void print() {
		System.out.println("[before] 로그 실행");
	}
}
