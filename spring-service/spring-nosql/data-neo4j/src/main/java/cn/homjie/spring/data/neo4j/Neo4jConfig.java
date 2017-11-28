package cn.homjie.spring.data.neo4j;

import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@org.springframework.context.annotation.Configuration
@EnableNeo4jRepositories(basePackages = "cn.homjie.spring.data.neo4j.dao")
@EnableTransactionManagement
public class Neo4jConfig {

	@Bean
	public SessionFactory sessionFactory() {
		// with domain entity base package(s)
		return new SessionFactory(configuration(), "cn.homjie.spring.data.neo4j.domain");
	}

	@Bean
	public Neo4jTransactionManager transactionManager() {
		return new Neo4jTransactionManager(sessionFactory());
	}

	@Bean
	public Configuration configuration() {
		Configuration config = new Configuration();
		config
				.driverConfiguration()
				.setURI("bolt://localhost:32775")
				.setCredentials("neo4j", "123456");
		return config;
	}
}