package cn.homjie.spring.wiring.inject;

import cn.homjie.spring.wiring.entity.Music;

import javax.inject.Named;

@Named
public class LightMusic implements Music {
	@Override
	public void sing() {
		System.out.println("light music sing");
	}
}
