package extendsex.override;

public class ComputerEx {
	public static void main(String[] args) {
		int r = 10;
		
		//재정의 메소드 사용 예시
		
		//super class 메소드 호출
		Calculator cal = new Calculator();
		System.out.println("원의 넓이 : " + cal.areaCircle(r));
		
		System.out.println();
		//subclass 메소드 호출
		
		
	}
}
