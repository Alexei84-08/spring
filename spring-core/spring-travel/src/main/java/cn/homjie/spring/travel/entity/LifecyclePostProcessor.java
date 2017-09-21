package cn.homjie.spring.travel.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class LifecyclePostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if ("lifecycle".equals(beanName))
			System.out.println("-- Lifecycle BeanPostProcessor before initiate");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if ("lifecycle".equals(beanName))
			System.out.println("-- Lifecycle BeanPostProcessor after initiate");
		return bean;
	}
}
