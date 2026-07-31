package exception.trycatch;

public class CatchOrderEx2 {

	public static void main(String[] args) {
		// catch부문이 여러번 있을 때 catch 순서에 따라 상위 클래스가 먼저 나타나면 해당 catch 실행하고 나머지 catch는 점프
		// 상위 클래스 처리가 하위 클래스 catch보다 먼저 나오면? 아래 catch는 무용지물 임
		// 상위 클래스 (Exception) 처리 catch는 가장 마지막에 놓는다.
		try {
			//String data1 = args[0];//args 매개변수 전달 안되면 ArrayIndexOutOfBoundsException
			//String data2 = args[1];
			String data1 = "abc";
			String data2 = "abc";
			
			System.out.println(Integer.parseInt("a100"));
			System.out.println("args[0]:"+data1);
			System.out.println("args[1]:"+data2);
		
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("실행 매개값의 수가 부족합니다");	
		}catch(Exception e) { //예외처리 클래스 중 최상위 클래스
			System.out.println("실행에 문제가 있습니다");
		}finally {
			System.out.println("다시 실행");
		}
		
		//두개 이상의 exception을 처리하기 위해 catch를 여러번 구성할 수도 있고
		//한개의 catch에 여러개의 exception 대입 가능
		try {

			System.out.println(arr[5]);
			System.out.println(Integer.parseInt("a100"));
			System.out.println(arr[2]);
		
		}catch(ArrayIndexOutOfBoundsException | NumberFormatException e) {
			System.out.println("실행 매개값의 수가 부족합니다");	
		}catch(Exception e) { //예외처리 클래스 중 최상위 클래스
			System.out.println("실행에 문제가 있습니다");
		}finally {
			System.out.println("다시 실행");
		}

	}

}
