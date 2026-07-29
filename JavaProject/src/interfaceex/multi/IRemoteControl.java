package interfaceex.multi;

public interface IRemoteControl {
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	void turnOn();
	void turnOff();
	void setVolume(int volume);
	
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 처리합니다");
		}else {
			System.out.println("무음 해제합니다");
		}
	}
	
	//정적 메소드 선언 : 인터페이스명을 이용해서 공용 사용
	static void changeBattery() {
		System.out.println("건전지를 교환합니다");
	}
}
