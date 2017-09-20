package cn.homjie.spring.wiring.java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaApplication.class);
		RapMusicPlayer player = context.getBean(RapMusicPlayer.class);
		player.play();
	}

	@Bean
	public RapMusic rapMusic() {
		return new RapMusic();
	}

	@Bean
	public RapMusicPlayer player(RapMusic music) {
		// 显示配置，推荐这种方式来引用其他的 bean
		RapMusicPlayer player = new RapMusicPlayer();
		player.setRapMusic(music);
		return player;
	}
}
