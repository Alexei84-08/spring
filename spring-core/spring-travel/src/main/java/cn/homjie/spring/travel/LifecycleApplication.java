package cn.homjie.spring.travel;

import cn.homjie.spring.travel.entity.BeanLifecycle;
import cn.homjie.spring.travel.entity.LifecyclePostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LifecycleApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifecycleApplication.class);
		BeanLifecycle lifecycle = context.getBean(BeanLifecycle.class);
		lifecycle.hello();
		System.out.println("[application shutdown]");
		context.close();
	}

	@Bean(initMethod = "customInititate", destroyMethod = "customDestory")
	public BeanLifecycle lifecycle() {
		return new BeanLifecycle();
	}

	@Bean
	public BeanPostProcessor lifecyclePostProcessor() {
		return new LifecyclePostProcessor();
	}
}
