package cn.homjie.spring.wiringx.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class NoteApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(NoteApplication.class);

		System.out.println(ctx.getBean(Note.class) == ctx.getBean(Note.class));
		System.out.println(ctx.getBean(Note.class).order());
	}
}
