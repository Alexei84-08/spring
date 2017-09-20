package cn.homjie.spring.wiring.inject;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class LightMusicPlayer {

	@Inject
	private LightMusic music;

	public void play() {
		music.sing();
	}
}
