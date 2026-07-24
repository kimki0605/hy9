package classInfo;

public class SingleTonEx {

	public static void main(String[] args) {
		// SingleTon 클래스 인스턴스 생성
		//ingleTon st = new Singleton(); //생성자 private
		
		//static 메소드인 getInstance() 호출
		SingleTon obj1 = SingleTon.getInstance();
		SingleTon obj2 = SingleTon.getInstance();
		
		if(obj1==obj2) {
			System.out.println("같은 객체를 참조합니다.");
		}else {
			System.out.println("다른 객체를 참조합니다.");
		}

	}

}
