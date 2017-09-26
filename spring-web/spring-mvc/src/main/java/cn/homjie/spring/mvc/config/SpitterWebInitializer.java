package cn.homjie.spring.mvc.config;

import cn.homjie.spring.mvc.web.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 配置 DispatcherServlet
 */
public class SpitterWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected String[] getServletMappings() {
		// 将 DispatcherServlet 映射到 "/"，表示为是应用的默认 Servlet，会处理进入应用的所有请求
		return new String[]{"/"};
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// ContextLoaderListener 创建应用上下文，通常是驱动应用后端的中间层和数据层组件
		return new Class[]{RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// Web 应用的 bean，如控制器、视图解析器以及处理器映射
		return new Class[]{WebConfig.class};
	}

}
