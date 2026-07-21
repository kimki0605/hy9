package condition;

import java.util.Scanner;

public class IfElseEx1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;
        String result;

        System.out.print("정수 입력 : ");
        num = sc.nextInt();

        if (num % 2 == 0)
            result = "짝수";
        else
            result = "홀수";

        System.out.println(result);

        sc.close();
    }
}