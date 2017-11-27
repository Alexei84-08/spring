package cn.homjie.spring.data.mongo;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "cn.homjie.spring.data.mongo.dao")
public class MongoConfig extends AbstractMongoConfiguration {

	// @EnableJpaRepositories 注解启用 MongoDB 的 Repository 功能

	@Override
	protected String getDatabaseName() {
		return "OrdersDB";
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient();
	}

}