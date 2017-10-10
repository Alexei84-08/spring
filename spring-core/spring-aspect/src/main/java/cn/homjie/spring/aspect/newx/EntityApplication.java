package cn.homjie.spring.aspect.newx;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

@Configuration
@ComponentScan
@EnableSpringConfigured
public class EntityApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EntityApplication.class);
		EntityBuilder builder = context.getBean(EntityBuilder.class);
		builder.create().exec();
	}

}