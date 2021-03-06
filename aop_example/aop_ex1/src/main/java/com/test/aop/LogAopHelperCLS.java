package com.test.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LogAopHelperCLS {

	@Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
	public void GetMapping(){ }

	@Before("GetMapping()")
	public void before(JoinPoint joinPoint) {
		log.info("===================== AspectJ TEST: Before Logging Start =====================");
		log.info("===================== AspectJ TEST: Before Logging End =====================");
	}

	@AfterReturning(pointcut = "GetMapping()", returning = "result")
	public void AfterReturning(JoinPoint joinPoint, Object result) {
		log.info("===================== AspectJ TEST: AfterReturning Logging Start =====================");
		log.info("===================== AspectJ TEST: AfterReturning Logging END =====================");
	}

	@Around("GetMapping()")
	public Object Around(ProceedingJoinPoint joinPoint) {
		Object result = null;
		log.info("===================== AspectJ TEST: Around Logging Start =====================");
		try {
			result = joinPoint.proceed();
			log.info("===================== AspectJ TEST: Around Logging END =====================");
			return result;
		} catch (Exception e) {
			return result;
		} catch (Throwable t) {
			return result;
		}
	}

}
