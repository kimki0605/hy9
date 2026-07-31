package api.arrays;

import java.util.Arrays;

public class Sortex {

	public static void main(String[] args) {
		// Arrays.sort(배열) : 항목 오름차순 정렬 메소드
		// 배열 타입이 기본타입이거나 String 배열인경우 사용가능
		String[] strAr = {"해바라기","가방","나비"};
		//String[] strAr1 = Arrays.sort(strAr); - 반환값 없음
		Arrays.sort(strAr); //오름차순으로 항목 정렬 - 문자열인 경우 첫문자로 비교, 첫문자가 동일하면 두번째 문자로 비교..
		
		for(String str : strAr) {
			System.out.println(str);
		}

	}

}
