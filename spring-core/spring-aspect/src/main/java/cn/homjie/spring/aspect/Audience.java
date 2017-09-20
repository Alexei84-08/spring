package cn.homjie.spring.aspect;

import org.aspectj.lang.annotation.*;

/**
 * 观众
 */
@Aspect
public class Audience {

	// @Before 通知方法会在目标方法调用之前执行
	// @After 通知方法会在目标方法返回或抛出异常后调用
	// @AfterReturning 通知方法会在目标方法返回后调用
	// @AfterThrowing 通知方法会在目标方法抛出异常后调用
	// @Around 通知方法会将目标方法封装起来

	@Pointcut("execution(* cn.homjie.spring.aspect.Performance.perform(..))")
	private void perform() {
		// 标记方法，定义切入点
	}

	@Before("perform()")
	public void silenceCellphones() {
		System.out.println("手机静音");
	}

	@Before("perform()")
	public void takeSeats() {
		System.out.println("坐下");
	}

	@AfterReturning("perform()")
	public void applause() {
		System.out.println("很精彩，鼓掌");
	}

	@AfterThrowing("perform()")
	public void refund() {
		System.out.println("很糟糕的表演，我们要退款");
	}
}
