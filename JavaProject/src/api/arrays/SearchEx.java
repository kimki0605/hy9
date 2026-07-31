package api.arrays;

import java.util.Arrays;

public class SearchEx {

	public static void main(String[] args) {
		//binarySearch(배열, 찾을 값), 사용 전에 sort 후 사용
		//기본 타입 값
		int[] scores = {99,97,98};
		int index = Arrays.binarySearch(scores, 99);
		System.out.println("찾은 인덱스 : " + index);

	}

}
