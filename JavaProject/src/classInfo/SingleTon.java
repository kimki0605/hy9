package classInfo;

public class SingleTon {
	//singleton 클래스의 객체 인스턴스를 1개만 생성되어 공유되도록 코딩
	private static SingleTon singleton = new SingleTon(); //private 은 클래스 내부에서는 사용가능 클래스 외부 사용 불가능
	
	private SingleTon() {};//private 은 클래스 내부에서는 사용가능 클래스 외부 사용 불가능
	
	static SingleTon getInstance() {
		return singleton;
	}
}
