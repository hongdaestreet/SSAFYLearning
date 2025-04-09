
public class 거듭제곱01 {
	public static void main(String[] args) {
		
	}
	
	static int powFor(int C,int N) {
		int result = 1;
		for (int i = 1; i<=N;i++) {
			result *= C;
		}
		return result;
	}
	
	static int powRecur(int C,int N) {
		if (N==1) return C;
		return C*powRecur(C,N-1);
	}
	
	// 분할 정복
	static int powDQ(int C,int N) {
		if (N==0)return 1;
		if (N%2==1) {
			return powDQ(C,(N-1)/2)*powDQ(C,(N-1)/2)*C;
		}else {
			return powDQ(C,N/2)*powDQ(C,N/2);
		}
	}
	
	static int powDQ2(int C,int N) {  // 연산 훨씬 덜거림
		if (N==0)return 1;
		if (N%2==1) {
			int tmp = powDQ2(C,(N-1)/2);
			return tmp*tmp*C;
		}else {
			int tmp = powDQ(C,N/2);
			return tmp*tmp;
		}
	}
	
}
