package exam;

public class SavingsMain {

    public static void main(String[] args) {

        Savings s = new Savings();

        s.setName();
        s.setBalance();

        System.out.println("예금주 : " + s.getName());
        System.out.println("입금전 잔액 : " + s.getBalance());

        s.inputDeposit();

        System.out.println("이자 : " + s.getInterest());
        System.out.println("최종 잔액 : " + s.getBalance());
    }
}