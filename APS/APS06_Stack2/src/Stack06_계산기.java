import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Stack06_계산기 {
	public static void main(String[] args) {
		String infix = "(6+5*(2-8)/2)";
		
		// 연산자 우선 순위 - '(' > '+,-' > '*,/'
		Map<Character,Integer> priority = new HashMap<>();
		priority.put('(',0);
		priority.put('+',1);
		priority.put('-',1);
		priority.put('*',2);
		priority.put('(',2);
		
		
		
		StringBuilder postfix = new StringBuilder();
		
		Stack<Character> op = new Stack<>();
		
		for(int i=0;i<infix.length();i++) {
			// '('
			if(infix.charAt(i) == '(') {
				op.push(infix.charAt(i));
			}
			// ')'
			else if(infix.charAt(i) == ')') {
				while(op.peek() !='(') {
					postfix.append(op.pop());
				}
				op.pop();
			}
			// 피연산자 (한자리라고 가정)
			else if (infix.charAt(i)>='0'&&infix.charAt(i)<='9') {
				postfix.append(infix.charAt(i));
			}
			// 연산자
			else {
				if (op.isEmpty()) {	// 공백O
					op.push(infix.charAt(i));
				}
				else {	// 공백X
					// 연산자 우선순위를 비교해서 써보기
					while (!op.isEmpty() && priority.get(op.peek())>=priority.get(infix.charAt(i))) {
						postfix.append(op.pop());
					}
					op.push(infix.charAt(i));
				}
			}
		}
		while (!op.isEmpty()) {
			postfix.append(op.pop());
		}
		System.out.println(postfix);
		
		///// 계산 /////
		Stack<Integer> calc = new Stack<>();
		for(int i=0;i<postfix.length();i++) {
			if (postfix.charAt(i)>='0'&&postfix.charAt(i)<='9') {
				calc.push(postfix.charAt(i)-'0');
			} else {
				int B = calc.pop();
				int A = calc.pop();
				
				switch(postfix.charAt(i)) {
				case '+':
					calc.push(A+B);
					break;
				case '-':
					calc.push(A-B);
					break;
				case '*':
					calc.push(A*B);
					break;
				case '/':
					calc.push(A/B);
					break;
				
				}
				
			}
		}
		System.out.println(calc.pop());
	}
}
