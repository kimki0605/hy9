package di_01com.di.xml_constructor_ex1;

public class TV {

	private Speaker speaker;

	// Setter
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public void volumeUp() {
		speaker.volumeUp();
	}

	public void volumeDown() {
		speaker.volumeDown();
	}
}