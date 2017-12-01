package cn.homjie.spring.security;

import cn.homjie.spring.security.service.SecuredSpittleService;
import cn.homjie.spring.security.service.SpittleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecuredConfig extends GlobalMethodSecurityConfiguration {

	// @EnableGlobalMethodSecurity 注解启用基于注解的方法安全性

	// Spring Security 自带的 @Secured 注解等价于 JSR-250 的 @RolesAllowed 注解
	// 使用 String 数组作为参数，代表多个权限，调用该方法至少需要具备其中的一个权限

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.inMemoryAuthentication()
				.withUser("user").password("password").roles("USER");
	}

	@Bean
	public SpittleService spitterService() {
		return new SecuredSpittleService();
	}

}
