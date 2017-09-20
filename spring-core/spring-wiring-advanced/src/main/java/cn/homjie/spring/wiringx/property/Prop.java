package cn.homjie.spring.wiringx.property;

import java.util.ArrayList;
import java.util.List;

public class Prop {

	private List<String> list = new ArrayList<>();

	public void store(String value) {
		list.add(value);
	}

	public void show() {
		System.out.println(list);
	}
}
