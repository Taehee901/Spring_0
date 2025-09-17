package com.example.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

// Advice 클래스 = 공통로직
// Aspect 클래스 = Advice + pointcut
@Log4j2
@Component
@Aspect
public class BeforeAdvice {

	@Pointcut("execution(* com.example..*Impl.*(..))")
	public void  allpointcut() {}

	@Before("allpointcut()")
	public void beforeLog(JoinPoint jp) {
		//메서드명
		String methodName = jp.getSignature().getName();
		//methodName += ":" + jp.toLongString();
		//methodName += ":" + jp.toShortString();

		//인수(argument)
		Object[] args = jp.getArgs();
		Object arg1 =  (args != null && args.length>0 ? args[0] : "") ;
		//sysout으로 해도 상관은 x -> 로그위치x
		//서버 운영중에는 로그레벨을 warn으로 올림
		log.info("[사전처리로그] beforeLog \n[" + methodName +"] [arg] " + arg1);//debug log레벨 warn log
	}
}