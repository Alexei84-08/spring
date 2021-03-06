package cn.homjie.spring.view.data;

import cn.homjie.spring.view.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcSpittleRepository implements SpittleRepository {

	private JdbcOperations jdbc;

	@Autowired
	public JdbcSpittleRepository(JdbcOperations jdbc) {
		this.jdbc = jdbc;
	}

	public List<Spittle> findRecentSpittles() {
		return jdbc.query(
				"SELECT id, message, created_at, latitude, longitude" +
						" FROM Spittle" +
						" ORDER BY created_at DESC LIMIT 20",
				new SpittleRowMapper());
	}

	public List<Spittle> findSpittles(long max, int count) {
		return jdbc.query(
				"SELECT id, message, created_at, latitude, longitude" +
						" FROM Spittle" +
						" WHERE id < ?" +
						" ORDER BY created_at DESC LIMIT 20",
				new SpittleRowMapper(), max);
	}

	public Spittle findOne(long id) {
		return jdbc.queryForObject(
				"SELECT id, message, created_at, latitude, longitude" +
						" FROM Spittle" +
						" WHERE id = ?",
				new SpittleRowMapper(), id);
	}

	public void save(Spittle spittle) {
		jdbc.update(
				"INSERT INTO Spittle (message, created_at, latitude, longitude)" +
						" VALUES (?, ?, ?, ?)",
				spittle.getMessage(),
				spittle.getTime(),
				spittle.getLatitude(),
				spittle.getLongitude());
	}

	private static class SpittleRowMapper implements RowMapper<Spittle> {
		public Spittle mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Spittle(
					rs.getLong("id"),
					rs.getString("message"),
					rs.getDate("created_at"),
					rs.getDouble("longitude"),
					rs.getDouble("latitude"));
		}
	}

}
