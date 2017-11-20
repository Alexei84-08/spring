package cn.homjie.spring.security.custom.dao;

import cn.homjie.spring.security.custom.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RoleDao {

	public static RoleRowMapper rowMapper = new RoleRowMapper();

	@Autowired
	private JdbcOperations jdbc;

	public List<Role> findByUserId(int userId) {
		return jdbc.query(
				"SELECT r.* FROM `role` r, `user_role` ur WHERE r.id = ur.role_id AND r.enabled = 1 AND ur.user_id = ?",
				rowMapper,
				userId);
	}

	private static class RoleRowMapper implements RowMapper<Role> {
		public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
			Role role = new Role();
			role.setId(rs.getInt("id"));
			role.setName(rs.getString("name"));
			role.setEnabled(rs.getBoolean("enabled"));
			return role;
		}
	}
}
