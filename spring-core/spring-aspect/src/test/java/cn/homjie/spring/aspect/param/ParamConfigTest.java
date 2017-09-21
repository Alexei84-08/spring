package cn.homjie.spring.aspect.param;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ParamConfig.class)
public class ParamConfigTest {

	@Autowired
	private UpperCase upperCase;

	@Test
	public void testUpper() {
		System.out.println(upperCase.upper("hello"));
	}

	@Test
	public void testCombine() {
		upperCase.combine("hello", "world");
	}

}