package cn.homjie.spring.security.custom.dao;

import cn.homjie.spring.security.custom.entity.Permission;
import cn.homjie.spring.security.custom.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PermissionDao {

	public static PermissionRowMapper rowMapper = new PermissionRowMapper();

	@Autowired
	private JdbcOperations jdbc;
	@Autowired
	private NamedParameterJdbcOperations jdbcNamed;

	public List<Permission> findByRoles(List<Role> roles) {
		if (roles == null || roles.isEmpty())
			return null;
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("roleIds", roles.stream().map(Role::getId).collect(Collectors.toList()));
		return jdbcNamed.query(
				"SELECT p.* FROM `permission` p, `role_permission` rp WHERE p.id = rp.permission_id AND p.enabled = 1 AND rp.role_id IN (:roleIds)",
				parameters,
				rowMapper);
	}

	private static class PermissionRowMapper implements RowMapper<Permission> {
		public Permission mapRow(ResultSet rs, int rowNum) throws SQLException {
			Permission permission = new Permission();
			permission.setId(rs.getInt("id"));
			permission.setAuthority(rs.getString("authority"));
			permission.setName(rs.getString("name"));
			permission.setEnabled(rs.getBoolean("enabled"));
			return permission;
		}
	}
}
