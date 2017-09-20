package cn.homjie.spring.wiring.auto;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AutoApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutoApplication.class);
		MusicPlayer player = context.getBean(MusicPlayer.class);
		player.play();
	}
}
