package cn.homjie.spring.wiringx.qualifier.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AnnotationApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AnnotationApplication.class);
		ctx.refresh();

		Dinner dinner = ctx.getBean(Dinner.class);
		dinner.taste();
	}
}
