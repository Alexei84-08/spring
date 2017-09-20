package cn.homjie.spring.wiringx.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class ProductMonitorCondition implements Condition {
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// 检查 profile 是否处于激活状态
		return context.getEnvironment().acceptsProfiles("prd");
	}
}
