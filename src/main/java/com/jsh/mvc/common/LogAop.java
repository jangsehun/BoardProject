package com.jsh.mvc.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAop {

	private Logger logger = LoggerFactory.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.jsh.mvc.controller.*.*(..))")
	public void forController() {};
	
	@Pointcut("execution(* com.jsh.mvc.biz.*.*(..))")
	public void forBiz() {};
	
	@Pointcut("execution(* com.jsh.mvc.dao.*.*(..))")
	public void forDao() {};
	
	@Pointcut("forBiz() || forController() || forDao()")
	public void forAll() {};
	
	@Before("forAll()")
	public void Before(JoinPoint join) {
		String method = join.getSignature().toShortString();
		Object[] args = join.getArgs();
		logger.info("=====>> @Before method : " + method);
		for(Object temp : args) {
			logger.info("<<===== @Before args : " + temp);
		}
	};
	
	@AfterReturning(pointcut="forAll()", returning="result")
	public void AfterReturning(JoinPoint join, Object result) {
		String method = join.getSignature().toShortString();
		logger.info("=====>> @After method : " + method);
		logger.info("=====>> @After return : " + result);
	};
	
	@AfterThrowing("forAll()")
	public void AfterThrowing(JoinPoint join) {
		logger.info("=====>> @AfterThrowing args : " + join.getArgs());
		logger.info("=====>> @AfterThrowing : " + join.toShortString());
	};
}