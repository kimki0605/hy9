package exam;

import java.util.Scanner;
import java.util.Stack;

public class StackEx1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수식 입력 : ");
		String expression = sc.nextLine();
		
		// 괄호를 저장할 Stack
		Stack stk = new Stack();
		
		boolean result = true;
		
		// 수식의 문자 하나씩 확인
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			
			// 여는 괄호이면 Stack에 저장
			if (ch == '(' || ch == '[' || ch == '{') {
				stk.push(ch);
			}
			
			// 닫는 괄호이면
			else if (ch == ')' || ch == ']' || ch == '}') {
				
				// 닫는 괄호인데 Stack이 비어있으면 잘못된 수식
				if (stk.isEmpty()) {
					result = false;
					break;
				}
				
				// 가장 최근에 저장된 여는 괄호 꺼내기
				char open = (char) stk.pop();
				
				// 괄호의 종류가 맞는지 확인
				if (ch == ')' && open != '(') {
					result = false;
					break;
				}
				
				if (ch == ']' && open != '[') {
					result = false;
					break;
				}
				
				if (ch == '}' && open != '{') {
					result = false;
					break;
				}
			}
		}
		
		// 모든 문자를 확인한 후 Stack에 괄호가 남아있으면 잘못된 수식
		if (!stk.isEmpty()) {
			result = false;
		}
		
		// 결과 출력
		if (result) {
			System.out.println("괄호가 올바른 수식입니다.");
		} else {
			System.out.println("괄호가 올바르지 않은 수식입니다.");
		}
		
		sc.close();
	}
}
