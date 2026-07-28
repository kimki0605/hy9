package extendsex.access1;

import extendsex.access.AAA; //public 클래스

public class CCC {
	public CCC() {
		AAA a = new AAA();
		
		a.field1 = 1;
		a.field2 = 1; //접근제한 default
		a.field3 = 1; //접근제한 private
		a.field4 = 1; //접근제한 protected, 상속 받은 경우 다른 패키지 사용 가능 
	}
}
