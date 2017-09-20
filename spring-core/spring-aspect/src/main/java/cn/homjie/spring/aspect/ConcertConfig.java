package cn.homjie.spring.aspect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class ConcertConfig {

	// @EnableAspectJAutoProxy 启用 AspectJ 自动代理，为 @Aspect 注解的 bean 创建一个代理，这个代理会围绕着所有该切面的切点所匹配的 bean。

	@Bean
	public Audience audience() {
		return new Audience();
	}
}
