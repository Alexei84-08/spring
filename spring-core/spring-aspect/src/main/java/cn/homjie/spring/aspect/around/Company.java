package cn.homjie.spring.aspect.around;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * 公司
 */
@Aspect
public class Company {

	@Around("cn.homjie.spring.aspect.simple.Audience.perform()")
	public void perform(ProceedingJoinPoint jp) {
		try {
			System.out.println("宣传、卖票");
			jp.proceed();
			System.out.println("谢谢大家来观看");
		} catch (Throwable e) {
			System.out.println("补偿观众");
		}
	}
}
