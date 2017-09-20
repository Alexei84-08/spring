package cn.homjie.spring.wiring.auto;

import cn.homjie.spring.wiring.entity.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {

	private Music music;

	// @Autowired 注解可以用在类的任何方法上，包括构造器和字段

	@Autowired
	public MusicPlayer(Music music) {
		this.music = music;
	}

	public void play() {
		music.sing();
	}
}
