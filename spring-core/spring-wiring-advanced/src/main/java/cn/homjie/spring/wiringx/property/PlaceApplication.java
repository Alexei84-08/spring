package cn.homjie.spring.wiringx.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class PlaceApplication {

	// 占位符装配属性，必须配置 PropertySourcesPlaceholderConfigurer 来解析占位符

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(PlaceApplication.class);
		Prop prop = ctx.getBean(Prop.class);
		prop.show();
	}

	@Bean
	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		configurer.setLocation(new ClassPathResource("app.properties"));
		return configurer;
	}

	@Bean
	public Prop prop(@Value("${application.id}") String id, @Value("${application.desc}") String desc) {
		Prop prop = new Prop();
		prop.store(id);
		prop.store(desc);
		return prop;
	}
}
