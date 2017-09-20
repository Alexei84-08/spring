package cn.homjie.spring.wiringx.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionConfig {

	// @Conditional 的条件为 true，则会创建 bean

	@Bean
	@Conditional(ProductMonitorCondition.class)
	public ProductMonitor monitor() {
		return new ProductMonitor();
	}
}
