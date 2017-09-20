package cn.homjie.spring.travel;

import cn.homjie.spring.travel.entity.LogAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Import(IocConfig.class)
@Configuration
@EnableAspectJAutoProxy
public class AopConfig {

	@Bean
	public LogAspect logAspect() {
		// 以声明的方式将它们应用到它们需要影响的组件中去
		return new LogAspect();
	}
}
