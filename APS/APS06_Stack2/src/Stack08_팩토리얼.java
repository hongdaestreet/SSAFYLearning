
public class Stack08_팩토리얼 {
	public static void main(String[] args) {
		System.out.println(fac(6));
	}
	
	public static int fac(int n) {
		System.out.println("func1 호출");
		if (n == 1) {
			return 1;
		}else {
			return fac(n-1)*n;
		}
	}
	
	
}
