package cn.homjie.spring.wiringx.profile.config;

import cn.homjie.spring.wiringx.entity.DataSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProfileApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles("dev");
		ctx.register(DevConfig.class, TestConfig.class, PrdConfig.class);
		ctx.refresh();

		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getClass().getSimpleName());
	}
}
