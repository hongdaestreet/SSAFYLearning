import java.util.Stack;

public class Stack03_괄호짝짓기 {
	
	public static void main(String[] args) {
 		String str="()()()()((())()))";
		
		Stack<Character> stack = new Stack<>();
		boolean isOk = true;
		for(int i=0;i<str.length();i++) {
			// 1. 여는 괄호면 넣기
			if(str.charAt(i) == '(') { // 기초자료형이라서 == 가능함
				stack.push(str.charAt(i));
			}
			// 2. 닫는 괄호라면
			else {
				if(stack.isEmpty()) {
					isOk = false;
					break;
				}else {
					char c = stack.pop(); // 검사
				}
			}
		}  // 괄호검사 끝 -> 정답 출력
		if (isOk && stack.isEmpty()) {
			System.out.println("정답");
		}else {
			System.out.println("거짓");
		}
	}
}
