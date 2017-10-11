package cn.homjie.spring.aspect.newx;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

@ComponentScan
@Configuration
@EnableSpringConfigured
@EnableLoadTimeWeaving
public class EntityApplication {

	public static void main(String[] args) {
		// VM option: -javaagent:E:/mavenRepository/org/springframework/spring-instrument/4.1.6.RELEASE/spring-instrument-4.1.6.RELEASE.jar
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EntityApplication.class);
		new Entity().exec();
	}

}