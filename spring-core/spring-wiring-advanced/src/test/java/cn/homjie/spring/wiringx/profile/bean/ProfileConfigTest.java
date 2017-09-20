package cn.homjie.spring.wiringx.profile.bean;

import cn.homjie.spring.wiringx.entity.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProfileConfig.class)
@ActiveProfiles("test")
public class ProfileConfigTest {

	@Autowired
	private DataSource dataSource;

	@Test
	public void run() {
		System.out.println(dataSource.getClass().getSimpleName());
	}

}