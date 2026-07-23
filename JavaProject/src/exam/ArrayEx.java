package exam;

import java.util.Scanner;

public class ArrayEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] name = new String[5];
		int[] gram = new int[5];
		int[] list = new int[5];
		int[] read = new int[5];

		char answer = 'y';
		int count = 0;

		System.out.println("*** 영어 시험 점수 입력 ***");

		while (answer == 'y' && count < 5) {

			System.out.printf("%d번 성명 입력 : ", count + 1);
			name[count] = sc.next();

			System.out.printf("%d번 문법 점수 입력 : ", count + 1);
			gram[count] = sc.nextInt();

			System.out.printf("%d번 듣기 점수 입력 : ", count + 1);
			list[count] = sc.nextInt();

			System.out.printf("%d번 독해 점수 입력 : ", count + 1);
			read[count] = sc.nextInt();

			count++;

			if (count < 5) {
				System.out.print("\n계속 입력하시겠습니까?(y입력하면 계속) : ");
				answer = sc.next().charAt(0);
			}
		}

		System.out.println("\n*** 영어 시험 결과 ***");

		for (int i = 0; i < count; i++) {

			int total = gram[i] + list[i] + read[i];
			int grade = 0;

			if (total >= 800) {
				grade = 1;
			} else if (total >= 600) {
				grade = 2;
			} else if (total >= 400) {
				grade = 3;
			} else {
				grade = 4;
			}

			System.out.printf("%d번 %s %d ", i + 1, name[i], total);

			switch (grade) {
			case 1:
				System.out.println("1등급");
				break;
			case 2:
				System.out.println("2등급");
				break;
			case 3:
				System.out.println("3등급");
				break;
			case 4:
				System.out.println("4등급");
				break;
			}
		}

		sc.close();
	}
}