package exception.trycatch;

public class CatchOrderEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String data1 = args[0];//args 매개변수 전달 안되면 ArrayIndexOutOfBoundsException
			String data2 = args[1];
			
			System.out.println("args[0]:"+data1);
			System.out.println("args[1]:"+data2);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("실행 매개값의 수가 부족합니다");
		}catch(Exception e) {
			System.out.println("실행에 문제가 있습니다");
		}finally {
			System.out.println("다시 실행");
		}

	}

}
