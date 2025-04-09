import java.util.Arrays;

class MyStack<E>{
	
}

public class Stack02_배열구현 {
	static String[] stack = new String[10];
	static int top = -1;  // -1은 스택이 공백상태
	
	// 삽입 (push)
	static boolean push(String value) {
		if (isFull()) {
			System.out.println("스택 용량 초과");
			return false;
		}
		stack[++top] = value;
		return true;
	}
	
	// 삭제 (pop)
	static String pop() {
		if(isEmpty()) {
			System.out.println("공백임");
			return null;
		}
		return stack[top--];
	}
	
	// 조회
	static String peek() {
		if (isEmpty()) {
			System.out.println("공백임");
			return null;
		}
		return stack[top];
	}
	
	
	// 공백
	static boolean isEmpty() {
//		if (top == -1) {
//			return false;
//		}
//		return true;
		return top == -1;
		
	}
	// 포화
	
	static boolean isFull() {
		return top == stack.length - 1;
	}
	
	public static void main(String[] args) {
 		push("Wkwkdaud");
 		push("꿔바로우");
 		System.out.println("꿔바로우");
 		System.out.println();
 		
 		
 		System.out.println(Arrays.toString(stack));
	}
}
