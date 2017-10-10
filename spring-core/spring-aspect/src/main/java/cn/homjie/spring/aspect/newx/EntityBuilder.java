package cn.homjie.spring.aspect.newx;

import org.springframework.stereotype.Component;

@Component
public class EntityBuilder {

	public Entity create() {
		return new Entity();
	}

}