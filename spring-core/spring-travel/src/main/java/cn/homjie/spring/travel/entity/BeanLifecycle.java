package cn.homjie.spring.travel.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BeanLifecycle implements InitializingBean, DisposableBean {

	public BeanLifecycle() {
		System.out.println("BeanLifecycle construct");
	}

	@PostConstruct
	public void beforeInitiate() {
		// @PostConstruct 等价于实现了 BeanPostProcessor 接口
		System.out.println("@PostConstruct BeanPostProcessor before initiate");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean after properties set");
	}

	public void customInititate() {
		System.out.println("custom initiate");
	}

	public void hello() {
		System.out.println("Hello");
	}

	@PreDestroy
	public void preDestroy() {
		// @PreDestroy 等价于实现了 DisposableBean 接口
		System.out.println("@PreDestroy DisposableBean before destroy");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean destory");
	}

	public void customDestory() {
		System.out.println("custom destory");
	}

}
