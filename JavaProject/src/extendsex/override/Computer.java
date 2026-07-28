package extendsex.override;

public class Computer extends Calculator {
	double areacircle(double r) {
		System.out.println("Computer 객체의 areaCircle() 실행 ");
		return Math.PI* r * r;
	}
}
