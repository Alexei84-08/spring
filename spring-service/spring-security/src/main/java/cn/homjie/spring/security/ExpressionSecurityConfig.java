package cn.homjie.spring.security;

import cn.homjie.spring.security.service.ExpressionSecuredSpittleService;
import cn.homjie.spring.security.service.SpittleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ExpressionSecurityConfig extends GlobalMethodSecurityConfiguration {

	// prePostEnabled = true 开启使用表达式实现方法级别的安全性

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.inMemoryAuthentication()
				.withUser("user").password("password").roles("USER")
				.and()
				.withUser("habuma").password("123456").roles("SPITTER")
				.and()
				.withUser("lemonguge").password("111111").roles("SPITTER");
	}

	@Bean
	public SpittleService spitterService() {
		return new ExpressionSecuredSpittleService();
	}

	@Override
	protected MethodSecurityExpressionHandler createExpressionHandler() {
		// Step2、将许可计算器注册到 Spring Security
		DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();
		expressionHandler.setPermissionEvaluator(new SpittlePermissionEvaluator());
		return expressionHandler;
	}
}
