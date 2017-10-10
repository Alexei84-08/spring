package cn.homjie.spring.mvcx.config;

import cn.homjie.spring.mvcx.web.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

public class SpitterWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

	/**
	 * 在 Servlet 中指定 multipart 的参数配置
	 *
	 * @param registration
	 */
	@Override
	protected void customizeRegistration(Dynamic registration) {
		// 上传文件目录
		// 上传文件的最大容量（以字节为单位）。默认是没有限制的。
		// 整个 multipart 请求的最大容量（以字节为单位），不会关心有多少个 part 以及每个 part 的大小。默认是没有限制的。
		// 在上传的过程中，如果文件大小达到了一个指定最大容量（以字节为单位），将会写入到临时文件路径中。默认值为 0，也就是所有上传的文件都会写入到磁盘上。
		registration.setMultipartConfig(new MultipartConfigElement("G:\\uploads", 2097152, 4194304, 0));
	}

}