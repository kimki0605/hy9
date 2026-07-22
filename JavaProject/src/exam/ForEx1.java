package exam;


public class ForEx1 {

	public static void main(String[] args) {
		int i, sum=0;
		for(i=1, sum=0; i<=10; i=i+2) {
			System.out.println(i);
			sum += i;
		}
		System.out.println("1~10 홀수의 합 : " + sum);

	}

}
