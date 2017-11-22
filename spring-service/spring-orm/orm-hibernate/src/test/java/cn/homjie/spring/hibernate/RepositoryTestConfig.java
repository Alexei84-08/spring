package cn.homjie.spring.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan
public class RepositoryTestConfig implements TransactionManagementConfigurer {

	// @EnableTransactionManagement 注解启用 declarative transaction

	@Autowired
	private SessionFactory sessionFactory;

	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder edb = new EmbeddedDatabaseBuilder();
		edb.setType(EmbeddedDatabaseType.H2);
		edb.addScript("schema.sql");
		edb.addScript("test-data.sql");
		return edb.build();
	}

	public PlatformTransactionManager annotationDrivenTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactoryBean() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("cn.homjie.spring.hibernate.domain");
		sessionFactory.setHibernateProperties(getHibernateProperties());
		return sessionFactory;
	}

	private Properties getHibernateProperties() {
		Properties props = new Properties();
		props.setProperty(AvailableSettings.DIALECT, "org.hibernate.dialect.H2Dialect");
		props.setProperty(AvailableSettings.SHOW_SQL, "true");
		props.setProperty(AvailableSettings.FORMAT_SQL, "true");
		return props;
	}
}
