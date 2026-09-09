package di_01com.di.xml_constructor_ex;

public class TV {

	private Speaker speaker;

	// 생성자 주입
	public TV(Speaker speaker) {
		this.speaker = speaker;
	}

	public void volumeUp() {
		speaker.volumeUp();
	}

	public void volumeDown() {
		speaker.volumeDown();
	}
}
