package exam;

import java.util.Scanner;

public class Savings {

    // 멤버 필드
    private String name;
    private int deposit;
    private int interest;
    private int balance;

    Scanner sc = new Scanner(System.in);

    // 예금주 설정
    public void setName() {
        name = "홍길동";
    }

    // 초기 잔액 설정
    public void setBalance() {
        balance = 10000;
    }

    // 예금주 반환
    public String getName() {
        return name;
    }

    // 예금액 입력 및 잔액 계산
    public void inputDeposit() {
        System.out.print("예금액 입력 : ");
        deposit = sc.nextInt();
        balance += deposit;
    }

    // 이자 계산 후 잔액 계산
    public int getInterest() {
        interest = (int)(balance * 0.1);
        balance += interest;
        return interest;
    }

    // 최종 잔액 반환
    public int getBalance() {
        return balance;
    }
}