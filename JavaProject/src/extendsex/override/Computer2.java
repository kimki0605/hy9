package extendsex.override;

public class Computer2 extends Calculator {
	//개발자의 실수로 오타가 남 : 메서드의 이름이 달라짐
	//부모 클래스 areaCircle()와 자식클래스의 areaCircle() 메서드가 생성됨
	//@Override가 필요
	@Override
	double areaCircle(double r) { //왼쪽 선언에 해당하는 메소드 선언부가 부모클래스에 없다는 오류, 메서드 이름이 다름
		System.out.println("Computer2 객체의 areaCircle() 실행");
		return Math.PI*r*r;
	}
}
