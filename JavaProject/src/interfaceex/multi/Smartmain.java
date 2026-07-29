package interfaceex.multi;

public class Smartmain {

	public static void main(String[] args) {
		// 다중인터페이스 구현 객체 할인
		SmartTelevision stv = new SmartTelevision();
		stv.turnOn();
		stv.search(null);
		stv.turnOff();
		
		//다중 인터페이스 다형성은 서의 사용하지 않는는다. 
		//IRemoteControl rc = new SmartTelevision();
		ISearchable sc = new SmartTelevision();
		

	}

}
