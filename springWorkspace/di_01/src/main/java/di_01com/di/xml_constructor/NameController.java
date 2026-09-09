package di_01com.di.xml_constructor;

public class NameController {
	//NameController입장에서 NameService는 의존관계임
	NameService nameService;
	public NameController(NameService nameService) { //생성자 통한 주입
		this.nameService = nameService;
	}
	public void show(String name) {
		System.out.println("NameController : " + nameService.showName(name));
	}
}
