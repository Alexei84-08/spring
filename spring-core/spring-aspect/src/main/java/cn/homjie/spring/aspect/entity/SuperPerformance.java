package cn.homjie.spring.aspect.entity;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class SuperPerformance implements Performance {

	private Random random = new Random();

	@Override
	public void perform() {
		if (random.nextBoolean()) {
			System.out.println("-- 表演失败");
			throw new PerformanceFailureException();
		}
		System.out.println("~~ 火力全开演出");
	}
}
