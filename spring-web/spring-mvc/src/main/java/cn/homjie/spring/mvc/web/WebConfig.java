package cn.homjie.spring.mvc.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("cn.homjie.spring.mvc.web")
public class WebConfig extends WebMvcConfigurerAdapter {

	// @EnableWebMvc 启用注解驱动，等价于 XML 中的 <mvc:annotation-driven>

	// @ComponentScan 启用组件扫描

	@Bean
	public ViewResolver viewResolver() {
		// 配置 JSP 视图解析器
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		// 会查找 JSP 文件，在查找的时候，它会在视图名称上加一个特定的前缀和后缀
		return resolver;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// 对静态资源的请求转发到 Servlet 容器中默认的 Servlet 上，而不是使用 DispatcherServlet 本身来处理此类请求。
		configurer.enable();
	}
}
