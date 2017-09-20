package cn.homjie.spring.wiring.java;

import cn.homjie.spring.wiring.entity.Music;

public class RapMusic implements Music {
	@Override
	public void sing() {
		System.out.println("rap music sing");
	}
}
