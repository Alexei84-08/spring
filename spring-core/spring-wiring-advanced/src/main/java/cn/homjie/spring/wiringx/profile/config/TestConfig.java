package cn.homjie.spring.wiringx.profile.config;

import cn.homjie.spring.wiringx.entity.DataSource;
import cn.homjie.spring.wiringx.entity.TestDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

	@Bean
	public DataSource dataSource() {
		return new TestDataSource();
	}
}
