package cn.homjie.spring.security.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

public class AbstractUserSecurityTest {

	protected void setupUser(String... privs) {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (String priv : privs) {
			authorities.add(new SimpleGrantedAuthority(priv));
		}
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken("user", "password", authorities);
		securityContext.setAuthentication(authenticationToken);
	}
}
