package exam;

public class Member {

    // 멤버 필드
    private String id;
    private String name;
    private int age;
    private String phone;
    private String address;

    // 기본 생성자 (홍길동으로 초기화)
    public Member() {
        this.id = "hkd";
        this.name = "홍길동";
        this.age = 30;
        this.phone = "010-1234-5678";
        this.address = "서울시 강남구 대치동";
    }

    // 생성자 (입력받은 값으로 초기화)
    public Member(String id, String name, int age, String phone, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }

    // 회원 정보 출력
    public void showMember() {
        System.out.println("------회원 정보 출력------");
        System.out.println("ID : " + id);
        System.out.println("성명 : " + name);
        System.out.println("나이 : " + age);
        System.out.println("전화 : " + phone);
        System.out.println("주소 : " + address);
    }
}