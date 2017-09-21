package cn.homjie.spring.aspect.simple;

import cn.homjie.spring.aspect.entity.Performance;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackageClasses = {Audience.class, Performance.class})
public class AudienceConfig {

	// @EnableAspectJAutoProxy 启用 AspectJ 自动代理，为 @Aspect 注解的 bean 创建一个代理，这个代理会围绕着所有该切面的切点所匹配的 bean。

}
