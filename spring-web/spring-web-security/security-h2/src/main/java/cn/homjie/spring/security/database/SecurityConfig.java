package cn.homjie.spring.security.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@Import(DataConfig.class)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

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
				.jdbcAuthentication()
				.dataSource(dataSource)
				.withDefaultSchema()
				// 如果密码明文存储的话，会很容易受到黑客的窃取。
				.passwordEncoder(new StandardPasswordEncoder("53cr3t"));
	}
}
