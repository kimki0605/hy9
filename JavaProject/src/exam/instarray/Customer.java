package exam.instarray;

public class Customer {

    int customerNo;
    String name;
    String phone;
    String job;
    String gender;
    int age;

    // 생성자
    public Customer(int customerNo, String name, String phone,
                    String job, String gender, int age) {

        this.customerNo = customerNo;
        this.name = name;
        this.phone = phone;
        this.job = job;
        this.gender = gender;
        this.age = age;
    }

    // 고객 정보 출력
    public void showCustomerInfo() {
        System.out.println(customerNo + " " + name + " " + phone + " "
                + job + " " + gender + " " + age);
    }
}