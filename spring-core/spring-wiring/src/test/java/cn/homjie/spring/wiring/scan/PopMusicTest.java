package cn.homjie.spring.wiring.scan;

import cn.homjie.spring.wiring.entity.Music;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ScanConfig.class)
public class PopMusicTest {

	// @ContextConfiguration 指定需要加载的配置类

	@Autowired
	private Music music;

	@Test
	public void play() {
		music.sing();
	}

}