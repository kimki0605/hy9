package exam.instarray;

import java.util.Scanner;

public class CustomerMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Customer[] customer = new Customer[3];

        System.out.println("****고객 정보 입력****");

        for (int i = 0; i < customer.length; i++) {

            System.out.print("고객번호 : ");
            int no = sc.nextInt();

            System.out.print("고객명 : ");
            String name = sc.next();

            System.out.print("전화번호 : ");
            String phone = sc.next();

            System.out.print("직업 : ");
            String job = sc.next();

            System.out.print("성별 : ");
            String gender = sc.next();

            System.out.print("나이 : ");
            int age = sc.nextInt();

            System.out.println();

            customer[i] = new Customer(no, name, phone, job, gender, age);
        }

        System.out.println("***고객 정보 출력***");

        for (int i = 0; i < customer.length; i++) {
            customer[i].showCustomerInfo();
        }

        sc.close();
    }
}