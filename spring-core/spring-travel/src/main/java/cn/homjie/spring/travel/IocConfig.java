package cn.homjie.spring.travel;

import cn.homjie.spring.travel.entity.DataSource;
import cn.homjie.spring.travel.entity.MysqlDataSource;
import cn.homjie.spring.travel.entity.OracleDataSource;
import cn.homjie.spring.travel.entity.TxManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IocConfig {

	// @Configuration 注解表明这个类是一个配置类

	// @Bean 注解会告诉 Spring 这个方法将会返回一个对象，该对象要注册为 Spring 应用上下文中的 bean，方法名为 bean 的 ID

	@Bean
	public DataSource mysql() {
		return new MysqlDataSource();
	}

	@Bean
	public DataSource oracle() {
		return new OracleDataSource();
	}


	// 对象的依赖关系将由系统中负责协调各对象的第三方组件在创建对象的时候进行设定
	@Bean
	public TxManager txManager() {
		// mysql()方法，Spring将会拦截所有对它的调用，并确保直接返回该方法所创建的 bean，而不是每次都对其进行实际的调用。
		return new TxManager(mysql());
	}
}
