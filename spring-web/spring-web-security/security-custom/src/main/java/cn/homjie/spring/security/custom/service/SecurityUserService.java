package cn.homjie.spring.security.custom.service;

import cn.homjie.spring.security.custom.dao.PermissionDao;
import cn.homjie.spring.security.custom.dao.RoleDao;
import cn.homjie.spring.security.custom.dao.UserDao;
import cn.homjie.spring.security.custom.entity.Permission;
import cn.homjie.spring.security.custom.entity.Role;
import cn.homjie.spring.security.custom.entity.SecurityUser;
import cn.homjie.spring.security.custom.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityUserService implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private PermissionDao permissionDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User '" + username + "' not found");
		}
		List<Role> roles = roleDao.findByUserId(user.getId());
		List<Permission> permissions = permissionDao.findByRoles(roles);
		return SecurityUser.builder(user).roles(roles).permissions(permissions).build();
	}
}
