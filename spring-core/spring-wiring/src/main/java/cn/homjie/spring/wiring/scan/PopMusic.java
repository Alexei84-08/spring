package cn.homjie.spring.wiring.scan;

import cn.homjie.spring.wiring.entity.Music;
import org.springframework.stereotype.Component;

/**
 * 流行音乐
 */
@Component
public class PopMusic implements Music {

	// Spring 应用上下文中所有的 bean 都会给定一个 ID，默认就是将类名的第一个字母变为小写。

	@Override
	public void sing() {
		System.out.println("pop music sing");
	}
}
