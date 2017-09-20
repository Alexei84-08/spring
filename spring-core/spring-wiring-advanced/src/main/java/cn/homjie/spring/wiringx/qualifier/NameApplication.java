package cn.homjie.spring.wiringx.qualifier;

import cn.homjie.spring.wiringx.entity.DataSource;
import cn.homjie.spring.wiringx.entity.DevDataSource;
import cn.homjie.spring.wiringx.entity.PrdDataSource;
import cn.homjie.spring.wiringx.entity.TestDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NameApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(NameApplication.class);
		Connection connection = ctx.getBean(Connection.class);
		connection.begin();
	}

	@Bean
	public DataSource dev() {
		return new DevDataSource();
	}

	@Bean
	public DataSource test() {
		return new TestDataSource();
	}

	// @Qualifier 将可选的 bean 的范围通过 bean 的 ID 缩小至一个

	@Bean
	public DataSource prd() {
		return new PrdDataSource();
	}

	@Bean
	public Connection connection(@Qualifier("dev") DataSource dataSource) {
		return new Connection(dataSource);
	}
}
