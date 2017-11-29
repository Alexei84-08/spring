package cn.homjie.spring.cache;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("cn.homjie.spring.cache.dao")
@Import({DataConfig.class, CachingConfig.class})
public class RootConfig {

}
