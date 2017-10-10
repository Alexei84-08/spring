package cn.homjie.spring.aspect.newx;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

@Component
@Configurable(autowire = Autowire.BY_TYPE)
public class Entity {

	@Autowired
	Engine engine;

	public void exec() {
		if (engine != null)
			engine.run();
		else
			System.out.println("exec failure");
	}

}