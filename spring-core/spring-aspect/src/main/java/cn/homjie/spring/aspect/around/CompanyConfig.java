package cn.homjie.spring.aspect.around;

import cn.homjie.spring.aspect.entity.Performance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackageClasses = Performance.class)
public class CompanyConfig {

	@Bean
	public Company company() {
		return new Company();
	}
}
