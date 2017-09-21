package cn.homjie.spring.aspect.extend;

public class TvLive implements Live {
	@Override
	public void online() {
		System.out.println("电视直播");
	}
}
