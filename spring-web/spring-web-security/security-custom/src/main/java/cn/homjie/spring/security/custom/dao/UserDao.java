package cn.homjie.spring.security.custom.dao;

import cn.homjie.spring.security.custom.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {

	public static UserRowMapper rowMapper = new UserRowMapper();

	@Autowired
	private JdbcOperations jdbc;

	public User findByUsername(String username) {
		if (username == null)
			return null;
		try {
			return jdbc.queryForObject(
					"SELECT * FROM `user` WHERE username=?",
					rowMapper,
					username);
		} catch (EmptyResultDataAccessException zero) {
			return null;
		}
	}

	private static class UserRowMapper implements RowMapper<User> {
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setEmail(rs.getString("email"));
			user.setEnabled(rs.getBoolean("enabled"));
			return user;
		}
	}

}
