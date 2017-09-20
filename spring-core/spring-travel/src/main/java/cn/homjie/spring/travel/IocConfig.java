package cn.homjie.spring.travel;

import cn.homjie.spring.travel.entity.DataSource;
import cn.homjie.spring.travel.entity.MysqlDataSource;
import cn.homjie.spring.travel.entity.OracleDataSource;
import cn.homjie.spring.travel.entity.TxManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IocConfig {

	@Bean
	public DataSource mysql() {
		return new MysqlDataSource();
	}

	@Bean
	public DataSource oracle() {
		return new OracleDataSource();
	}

	@Bean
	public TxManager txManager() {
		// 对象的依赖关系将由系统中负责协调各对象的第三方组件在创建对象的时候进行设定
		return new TxManager(mysql());
	}
}
