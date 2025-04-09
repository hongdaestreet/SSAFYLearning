
public class Stack10_하노이탑 {
	public static void main(String[] args) {
		System.out.println(fibo(6));
	}
	
	public static int fibo(int n) {
		if (n==1) {
			return 1;
		}
		else if (n==0){
			return 0;
		}
		else {
			return fibo(n-1)+fibo(n-2);
		}
	}
	
	
}
