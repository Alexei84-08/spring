package cn.homjie.spring.wiringx.qualifier.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Dinner {

	private Dessert dessert;

	@Autowired
	@Cold
	@Fruity
	public void setDessert(Dessert dessert) {
		this.dessert = dessert;
	}

	public void taste() {
		System.out.println(dessert.getClass().getSimpleName() + " taste delicious");
	}
}
