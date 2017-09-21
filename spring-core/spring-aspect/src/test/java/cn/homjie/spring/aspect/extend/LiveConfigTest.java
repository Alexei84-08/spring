package cn.homjie.spring.aspect.extend;

import cn.homjie.spring.aspect.entity.Performance;
import cn.homjie.spring.aspect.entity.PerformanceFailureException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = LiveConfig.class)
public class LiveConfigTest {

	@Autowired
	private Performance performance;

	@Test
	public void perform() {
		try {
			performance.perform();
		} catch (PerformanceFailureException ex) {
		}
		// 扩展接口
		Live live = (Live) performance;
		live.online();
	}

}