package cn.homjie.spring.aspect.param;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ParamApsect {

	// Step1、切点表达式中的 args(param) 限定符。它表明传递给方法的参数也会传递到通知中去。args 中参数的名称 param 也与切点方法签名中的参数相匹配。

	@Pointcut("execution(* cn.homjie.spring.aspect.param.UpperCase.upper(String)) && args(value)")
	private void upper(String value) {
	}

	// Step2、切点定义中的参数与通知方法中的参数名称是一样的，这样就完成了从切点到通知方法的参数转移。

	@Before("upper(param)")
	public void beforeUpper(String param) {
		System.out.println("-- 准备处理[" + param + "]");
	}

	@Pointcut("execution(* cn.homjie.spring.aspect.param.UpperCase.combine(..))")
	private void combine() {
	}

	@AfterReturning(pointcut = "combine()", returning = "rv")
	public void afterCombine(String rv) {
		System.out.println("-- 返回结果[" + rv + "]");
	}

	@Pointcut("execution(* cn.homjie.spring.aspect.param.UpperCase.combine(..)) && args(s, ..)")
	private void combineSingle(String s) {
	}

	@Before("combineSingle(src)")
	public void beforeCombineReadFirstParam(String src) {
		System.out.println("-- 第一个参数[" + src + "]");
	}

}
