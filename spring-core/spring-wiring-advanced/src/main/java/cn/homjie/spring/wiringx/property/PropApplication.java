package cn.homjie.spring.wiringx.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:app.properties")
public class PropApplication {

	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(PropApplication.class);
		Prop prop = ctx.getBean(Prop.class);
		prop.show();
	}

	@Bean
	public Prop prop(@Value("${application.id}") String id) {
		Prop prop = new Prop();
		// 使用 @PropertySource 声明属性源并通过 Spring 的 Environment 来检索属性
		prop.store(id);
		prop.store(environment.getProperty("application.desc"));
		return prop;
	}
}
