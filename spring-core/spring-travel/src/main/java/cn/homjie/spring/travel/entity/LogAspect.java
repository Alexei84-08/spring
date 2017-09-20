package cn.homjie.spring.travel.entity;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAspect {

	@Pointcut("target(cn.homjie.spring.travel.entity.TxManager)")
	private void txManagerPointcut() {
		// the pointcut signature
	}

	@Before("txManagerPointcut()")
	public void beforeStartTransaction() {
		System.out.println("Log: before start transaction");
	}

	@After("txManagerPointcut()")
	public void afterStartTransaction() {
		System.out.println("Log: after start transaction");
	}
}
