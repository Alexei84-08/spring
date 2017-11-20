package cn.homjie.spring.security.custom;

import cn.homjie.spring.security.custom.service.SecurityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@Import(DataConfig.class)
@ComponentScan("cn.homjie.spring.security.custom")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private SecurityUserService securityUserService;

	@Override
	public void configure(WebSecurity web) throws Exception {
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
				.userDetailsService(securityUserService).addObjectPostProcessor(new HideUserNotFoundExceptionProcessor());
	}

	private class HideUserNotFoundExceptionProcessor implements ObjectPostProcessor<AbstractUserDetailsAuthenticationProvider> {

		@Override
		public AbstractUserDetailsAuthenticationProvider postProcess(AbstractUserDetailsAuthenticationProvider object) {
			// 展示未找到用户的异常，否则提示密码不准确
			object.setHideUserNotFoundExceptions(false);
			return object;
		}
	}
}
