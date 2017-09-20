package cn.homjie.spring.wiring.auto;

import cn.homjie.spring.wiring.entity.Music;
import org.springframework.stereotype.Component;

/**
 * 古典音乐
 */
@Component("music")
public class ClassicalMusic implements Music {
	@Override
	public void sing() {
		System.out.println("classical music sing");
	}
}
