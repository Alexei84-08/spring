package cn.homjie.spring.security.custom.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class SecurityUser implements UserDetails, Serializable {

	private static final long serialVersionUID = 1838428100316102521L;

	private User user;
	private List<Role> roles = new ArrayList<>();
	private List<GrantedAuthority> authorities = new ArrayList<>();

	private SecurityUser() {
	}

	public static SecurityUserBuilder builder(User user) {
		return new SecurityUser().new SecurityUserBuilder(user);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return user.isEnabled();
	}

	public User getUser() {
		return user;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public class SecurityUserBuilder {

		private SecurityUserBuilder(User user) {
			SecurityUser.this.user = user;
		}

		public SecurityUser build() {
			return SecurityUser.this;
		}

		public SecurityUserBuilder roles(Collection<Role> roles) {
			if (roles != null && !roles.isEmpty()) {
				roles
						.stream()
						.filter(Objects::nonNull)
						.forEach(SecurityUser.this.roles::add);
			}
			return this;
		}

		public SecurityUserBuilder permissions(List<Permission> permissions) {
			if (permissions != null && !permissions.isEmpty()) {
				permissions
						.stream()
						.filter(Objects::nonNull)
						.map(Permission::getAuthority)
						.forEach(auth -> authorities.add(new SimpleGrantedAuthority(auth)));
			}
			return this;
		}

	}
}
