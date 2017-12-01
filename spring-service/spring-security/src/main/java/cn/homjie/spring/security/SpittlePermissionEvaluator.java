package cn.homjie.spring.security;

import cn.homjie.spring.security.domain.Spittle;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.Serializable;

// Step1、定义许可计算器
public class SpittlePermissionEvaluator implements PermissionEvaluator {

	private static final GrantedAuthority ADMIN_AUTHORITY = new SimpleGrantedAuthority("ROLE_ADMIN");

	@Override
	public boolean hasPermission(Authentication authentication, Object target, Object permission) {
		// target 评估对象
		if (target instanceof Spittle) {
			Spittle spittle = (Spittle) target;
			String username = spittle.getSpitter().getUsername();
			if ("delete".equals(permission)) {
				return isAdmin(authentication) || username.equals(authentication.getName());
			}
		}
		throw new UnsupportedOperationException("hasPermission not supported for object <" + target
				+ "> and permission <" + permission + ">");
	}

	@Override
	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
		throw new UnsupportedOperationException();
	}

	private boolean isAdmin(Authentication authentication) {
		return authentication.getAuthorities().contains(ADMIN_AUTHORITY);
	}
}
