package cn.homjie.spring.security.travel;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityWebInitializer extends AbstractSecurityWebApplicationInitializer {

	// DelegatingFilterProxy 将过滤逻辑委托给 springSecurityFilterChain 过滤器 Bean

	public SecurityWebInitializer() {
		super(SecurityConfig.class);
	}
}
