package cn.homjie.spring.aspect.extend;

import cn.homjie.spring.aspect.entity.Performance;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackageClasses = {Live.class, Performance.class})
public class LiveConfig {
}
