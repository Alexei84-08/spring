package cn.homjie.spring.wiring.scan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ScanConfig {

	// 组件扫描默认是不启用的，显式配置一下 @ComponentScan 注解，
	// 这个注解能够在 Spring 中启用组件扫描，默认扫描与配置类相同的包以及这个包下的所有子包。
}
