package cn.homjie.spring.wiring.java;

public class RapMusicPlayer {

	private RapMusic rapMusic;

	public void setRapMusic(RapMusic rapMusic) {
		this.rapMusic = rapMusic;
	}

	public void play() {
		rapMusic.sing();
	}
}
