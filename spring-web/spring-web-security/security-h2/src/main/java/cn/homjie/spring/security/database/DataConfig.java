package cn.homjie.spring.security.database;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DataConfig {

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.build();
	}

	@Bean
	public Server h2TcpServer() throws SQLException {
		return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092").start();
	}

	/**
	 * Web console for the embedded h2 database.
	 * <p>
	 * Go to http://localhost:8082 and connect to the database "jdbc:h2:mem:testdb", username "sa", password empty.
	 * </p>
	 */
	@Bean
	public Server h2WebServer() throws SQLException {
		return Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082").start();
	}

}
