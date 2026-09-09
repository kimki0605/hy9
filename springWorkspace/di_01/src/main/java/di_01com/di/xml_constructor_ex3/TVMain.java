package di_01com.di.xml_constructor_ex3;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVMain {

	public static void main(String[] args) {

		AbstractApplicationContext context =
				new GenericXmlApplicationContext("application-context3_1.xml");

		TV tv = context.getBean("tv", TV.class);

		tv.volumeUp();
		tv.volumeDown();

		context.close();
	}
}