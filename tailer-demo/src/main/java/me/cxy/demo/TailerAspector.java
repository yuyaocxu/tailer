package me.cxy.demo;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.cxy.tailer.Tailer;

@Aspect
@Component
public class TailerAspector {
	
	@Autowired
	private Tailer tailer;

	@Pointcut("execution(* me.cxy.demo.*..*.*(..))")
	public void tailer() {
	}

	@Before("tailer()")
	public void doBefore(JoinPoint joinPoint) {
		tailer.arrive(joinPoint.toShortString());
	}

	@After("tailer()")
	public void doAfter(JoinPoint joinPoint) {
		tailer.leave();
	}

}
