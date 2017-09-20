package cn.homjie.spring.wiringx.profile.bean;

import cn.homjie.spring.wiringx.entity.DataSource;
import cn.homjie.spring.wiringx.entity.DevDataSource;
import cn.homjie.spring.wiringx.entity.PrdDataSource;
import cn.homjie.spring.wiringx.entity.TestDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileConfig {

	@Bean
	@Profile("dev")
	public DataSource dev() {
		return new DevDataSource();
	}

	@Bean
	@Profile("test")
	public DataSource test() {
		return new TestDataSource();
	}

	@Bean
	@Profile("prd")
	public DataSource prd() {
		return new PrdDataSource();
	}
}
