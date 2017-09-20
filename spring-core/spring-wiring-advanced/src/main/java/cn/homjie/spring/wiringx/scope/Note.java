package cn.homjie.spring.wiringx.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 笔记
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Note {

	// @Scope 作用域为 prototype 时，每次注入或者通过 Spring 应用上下文获取的时候，都会创建一个新的 bean 实例

	// @Scope 使用会话和请求作用域时，可以设置 proxyMode 属性来解决 bean 注入到单例 bean 中所遇到的问题（延迟注入）
	// 用户没有会话或请求时，bean 是不存在的，注入会出错，使用了代理会对其进行懒解析并将调用委托给真正的 bean

	private static final AtomicInteger COUNTER = new AtomicInteger();

	private int order = COUNTER.incrementAndGet();

	public int order() {
		return order;
	}
}
