package cn.homjie.spring.security.travel;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// @EnableWebSecurity 注解将会启用 Web 安全功能
	// @EnableWebSecurity 注解导入配置 WebSecurityConfiguration，将注册 springSecurityFilterChain 过滤器 Bean

	@Override
	public void configure(WebSecurity web) throws Exception {
		// 用于影响全局安全性的配置设置（忽略资源，设置调试模式，通过实现自定义防火墙定义拒绝请求）
		web.ignoring().antMatchers("/resources/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 控制权限，角色，URL 等安全
		http
			.authorizeRequests()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.permitAll()
				.successForwardUrl("/logout.jsp");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 建立认证机制
		auth
			.inMemoryAuthentication()
				.withUser("user").password("password").roles("USER")
				.and()
				.withUser("admin").password("password").roles("USER", "ADMIN");
	}
}
