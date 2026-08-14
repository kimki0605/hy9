package datastructure.queue;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ParkingMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 주차 가능 대수 입력
		System.out.print("주차 가능 대수 입력 : ");
		int capacity = sc.nextInt();

		// 큐 생성
		MyQueueMove parking = new MyQueueMove(capacity);

		// 차량별 주차 시간 저장
		Map<Character, Long> parkingTime = new HashMap<>();

		int menu;

		while (true) {

			System.out.println();
			System.out.println("===== 주차 관리 프로그램 =====");
			System.out.println("0. 주차 여부 확인");
			System.out.println("1. 자동차 주차");
			System.out.println("2. 자동차 출차");
			System.out.println("3. 만차 여부");
			System.out.println("4. 종료");
			System.out.print("메뉴 선택 : ");

			menu = sc.nextInt();

			// 0. 주차 여부 확인
			if (menu == 0) {

				if (parking.isEmpty()) {
					System.out.println("주차된 차량이 없습니다.");
				} else {
					parking.showQueue();
				}

			}

			// 1. 자동차 주차
			else if (menu == 1) {

				if (parking.isFull()) {
					System.out.println("주차장이 만차입니다.");
				} else {

					System.out.print("주차할 차량의 고유 문자 입력 : ");
					char car = sc.next().charAt(0);

					// 이미 주차되어 있는 차량인지 확인
					if (parkingTime.containsKey(car)) {

						System.out.println("이미 주차된 차량입니다.");

					} else {

						parking.enqueue(car);

						// 현재 시간을 저장
						parkingTime.put(car, System.currentTimeMillis());

						System.out.println(car + " 차량이 주차되었습니다.");
					}
				}

			}

			// 2. 자동차 출차
			else if (menu == 2) {

				if (parking.isEmpty()) {

					System.out.println("주차된 차량이 없습니다.");

				} else {

					System.out.print("출차할 차량의 고유 문자 입력 : ");
					char car = sc.next().charAt(0);

					// 해당 차량이 주차되어 있는지 확인
					if (!parkingTime.containsKey(car)) {

						System.out.println("주차되어 있지 않은 차량입니다.");

					} else {

						// 주차 후 경과 시간 계산
						long currentTime = System.currentTimeMillis();
						long startTime = parkingTime.get(car);

						long elapsedTime = currentTime - startTime;

						// 1시간 = 60분 = 60 * 60 * 1000 밀리초
						long oneHour = 60 * 60 * 1000;

						if (elapsedTime < oneHour) {

							System.out.println(
									car + " 차량은 주차 후 1시간이 지나지 않았습니다."
							);

						} else {

							/*
							 * 큐에서 해당 차량을 찾는다.
							 * 해당 차량 앞에 있는 차량들은 다시 큐에 넣는다.
							 */
							boolean found = false;
							int count = parking.size();

							for (int i = 0; i < count; i++) {

								char temp = parking.dequeue();

								if (temp == car) {

									found = true;
									parkingTime.remove(car);

									System.out.println(
											car + " 차량이 출차되었습니다."
									);

								} else {

									parking.enqueue(temp);
								}
							}

							if (!found) {
								System.out.println("출차할 차량을 찾을 수 없습니다.");
							}
						}
					}
				}

			}

			// 3. 만차 여부
			else if (menu == 3) {

				if (parking.isFull()) {
					System.out.println("주차장이 만차입니다.");
				} else {
					System.out.println(
							"주차 가능 : " + (capacity - parking.size()) + "대"
					);
				}

			}

			// 4. 종료
			else if (menu == 4) {

				System.out.println("프로그램을 종료합니다.");
				break;

			}

			else {

				System.out.println("잘못된 메뉴입니다.");

			}
		}

		sc.close();
	}
}
