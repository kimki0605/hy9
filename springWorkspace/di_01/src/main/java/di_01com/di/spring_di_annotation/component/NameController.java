package di_01com.di.spring_di_annotation.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class NameController {
	
	@Autowired
	iNameInterface nameService; //name속성을 생략하는 필드이름과 동일한 id의 bean을 찾음
	
	public void show(String name) {
		System.out.println("NameController : " + nameService.showName(name));
	}
}
