package cn.homjie.spring.wiringx.qualifier;

import cn.homjie.spring.wiringx.entity.DataSource;
import cn.homjie.spring.wiringx.entity.DevDataSource;
import cn.homjie.spring.wiringx.entity.PrdDataSource;
import cn.homjie.spring.wiringx.entity.TestDataSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PrimaryApplication {

	// @Primary 将可选bean中的某一个设为首选（primary）的 bean

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(PrimaryApplication.class);
		Connection connection = ctx.getBean(Connection.class);
		connection.begin();
	}

	@Bean
	@Primary
	public DataSource dev() {
		return new DevDataSource();
	}

	@Bean
	public DataSource test() {
		return new TestDataSource();
	}

	@Bean
	public DataSource prd() {
		return new PrdDataSource();
	}

	@Bean
	public Connection connection(DataSource dataSource) {
		return new Connection(dataSource);
	}
}
