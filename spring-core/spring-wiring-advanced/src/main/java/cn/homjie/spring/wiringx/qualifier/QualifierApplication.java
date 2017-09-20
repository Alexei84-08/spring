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
public class QualifierApplication {

	// 使用 @Qualifier 创建自定义的限定符

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(QualifierApplication.class);
		Connection connection = ctx.getBean(Connection.class);
		connection.begin();
	}

	@Bean
	@Qualifier("devDataSource")
	public DataSource dev() {
		return new DevDataSource();
	}

	@Bean
	@Qualifier("testDataSource")
	public DataSource test() {
		return new TestDataSource();
	}

	@Bean
	@Qualifier("prdDataSource")
	public DataSource prd() {
		return new PrdDataSource();
	}

	@Bean
	public Connection connection(@Qualifier("prdDataSource") DataSource dataSource) {
		return new Connection(dataSource);
	}
}
