package cn.homjie.spring.aspect.simple;

import cn.homjie.spring.aspect.entity.Performance;
import cn.homjie.spring.aspect.entity.PerformanceFailureException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AudienceConfig.class)
public class AudienceConfigTest {

	@Autowired
	private Performance performance;

	@Test
	public void perform() {
		// JDK 动态代理
		try {
			performance.perform();
		} catch (PerformanceFailureException ex) {
		}
	}

}