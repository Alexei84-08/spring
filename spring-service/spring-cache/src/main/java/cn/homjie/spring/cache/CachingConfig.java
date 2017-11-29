package cn.homjie.spring.cache;

import net.sf.ehcache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching
public class CachingConfig {

	// @EnableCaching 启用注解驱动的缓存

	@Bean
	public EhCacheCacheManager cacheManager(CacheManager cm) {
		// 使用 EhCache 作为缓存管理器
		return new EhCacheCacheManager(cm);
	}

	@Bean
	public EhCacheManagerFactoryBean ehcache() {
		EhCacheManagerFactoryBean ehCacheFactoryBean = new EhCacheManagerFactoryBean();
		// 指明 EhCache 配置文件
		ehCacheFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
		return ehCacheFactoryBean;
	}

}
