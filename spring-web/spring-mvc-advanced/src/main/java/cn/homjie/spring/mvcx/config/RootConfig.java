package cn.homjie.spring.mvcx.config;

import cn.homjie.spring.mvcx.config.RootConfig.WebPackage;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

import java.util.regex.Pattern;

@Configuration
@Import(DataConfig.class)
@ComponentScan(basePackages = {"cn.homjie.spring.mvcx"},
		excludeFilters = {
				@Filter(type = FilterType.CUSTOM, value = WebPackage.class)
		})
public class RootConfig {
	public static class WebPackage extends RegexPatternTypeFilter {
		public WebPackage() {
			super(Pattern.compile("cn\\.homjie\\.\\\\spring\\.mvcx\\.web"));
		}
	}
}
