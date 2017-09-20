package cn.homjie.spring.aspect;

import org.springframework.stereotype.Component;

@Component
public class SuperPerformance implements Performance {
	@Override
	public void perform() {
		System.out.println("火力全开演出");
	}
}
