package cn.homjie.spring.wiringx.condition;

import javax.annotation.PostConstruct;

/**
 * 生产环境下的监控器
 */
public class ProductMonitor {

	@PostConstruct
	public void beforeInitiate() {
		System.out.println("product monitor start");
	}
}
