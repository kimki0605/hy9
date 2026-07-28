package interfaceex;

public class Iphone implements ISmartPhone {
	String name;
	
	public Iphone() {
		name = "아이폰";
	}
	
	@Override
	public void sendCall() {
		System.out.println(name + "으로 잔회를 겁니다");
	}
	
	@Override
	public void receiveCall() {
		
	}
}
