package cn.homjie.spring.aspect.around;

import cn.homjie.spring.aspect.entity.Performance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CompanyConfig.class)
public class CompanyConfigTest {

	@Autowired
	private Performance performance;

	@Test
	public void perform() {
		performance.perform();
	}
}