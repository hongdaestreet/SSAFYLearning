import java.util.Arrays;

public class Stack09_피보나치 {
	static int[] count = new int[100];
	public static void main(String[] args) {
		System.out.println(fibo(10));
		System.out.println(mFibo(10));
		System.out.println(Arrays.toString(count));
	}
	
	public static int fibo(int n) {
		count[n]++;
		if (n<2) {
			return n;
		}
		else {
			return fibo(n-1)+fibo(n-2);
		}
	}
	
	static int[] memo = new int[1000];
	static {
		memo[0] = 0;
		memo[1] = 1;
	}
	
	
	public static int mFibo(int n) {
		if (n>=2&&memo[n]==0) {
			memo[n] = mFibo(n-1) + mFibo(n-2);
		}
		return memo[n];
	}
	
	
}
