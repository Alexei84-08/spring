package cn.homjie.spring.security.travel;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// @EnableWebSecurity 注解将会启用 Web 安全功能
	// @EnableWebSecurity 注解导入配置 WebSecurityConfiguration，将注册 springSecurityFilterChain 过滤器 Bean

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER")
				.and().withUser("admin").password("password").roles("USER", "ADMIN");
	}
}
