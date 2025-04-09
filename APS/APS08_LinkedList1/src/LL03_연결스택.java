import 연결스택.LinkedStack;

public class LL03_연결스택 {
	public static void main(String[] args) {
		LinkedStack stack = new LinkedStack();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());		
		
	}
}
