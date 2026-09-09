package di_01com.di.xml_constructor_ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVMain {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("application-context2_1.xml");

		TV tv = (TV) context.getBean("tv"); //Speaker 객체가 setter 통해서 주입됨

		tv.volumeUp();
		tv.volumeDown();
	}
}