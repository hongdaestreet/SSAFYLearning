import java.util.Stack;

public class Stack01_API {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		System.out.println(stack.size());
		
		// for문에 i<stack.size() 하면 stack 사이즈가 변동돼서 크기 값 고정해야 함
		int stSize = stack.size();
		for (int i=0;i<stSize;i++) {
			System.out.println(stack.pop());
		}
		System.out.println(stack.size());
		
	}
}
