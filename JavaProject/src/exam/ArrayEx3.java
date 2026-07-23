package exam;

import java.util.Random;

public class ArrayEx3 {

	public static void main(String[] args) {

		Random random = new Random();
		int[] Rnum = new int[10];

		// 랜덤 숫자 저장
		for (int i = 0; i < 10; i++) {
			Rnum[i] = random.nextInt(10);
		}

		// 배열 출력
		for (int i = 0; i < 10; i++) {
			System.out.print(Rnum[i] + " ");
		}

		System.out.println("\n");

		// 숫자별 개수 출력
		for (int j = 0; j < 10; j++) {

			int count = 0;

			for (int i = 0; i < 10; i++) {
				if (Rnum[i] == j) {
					count++;
				}
			}

			System.out.printf("%d의 개수 : %d개\n", j, count);
		}

	}

}