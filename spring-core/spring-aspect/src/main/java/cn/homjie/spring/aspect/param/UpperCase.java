package cn.homjie.spring.aspect.param;

import org.springframework.stereotype.Component;

@Component
public class UpperCase {

	public String upper(String word) {
		return word.toUpperCase();
	}

	public String combine(String a, String b) {
		return a + " " + b;
	}
}
