package cn.homjie.spring.wiring.inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = InjectConfig.class)
public class LightMusicPlayerTest {

	@Inject
	private LightMusicPlayer player;

	@Test
	public void play() throws Exception {
		player.play();
	}

}