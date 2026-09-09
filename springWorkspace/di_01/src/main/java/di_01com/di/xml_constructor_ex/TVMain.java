package di_01com.di.xml_constructor_ex;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVMain {

	public static void main(String[] args) {

		ApplicationContext context =
				new ClassPathXmlApplicationContext("application-context1_1.xml");

		TV tv = (TV) context.getBean("tv");

		tv.volumeUp();
		tv.volumeDown();
	}
}