package sort;

public class ShellMain {

	public static void main(String[] args) {
		int[] arr = {10,8,6,20,4,3,22,1,0,15,16};
		
		System.out.println("초기배열 : ");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		Shellsort.shellSort(arr);
		
		System.out.println();
		
		System.out.println("\n정렬 결과");

	}

}
