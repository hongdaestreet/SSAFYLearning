public class String03_atoi_itoa {
	 public static void main(String[] args) {
		String strNum = "123456";
		int num = Integer.parseInt(strNum);
		System.out.println(num);
		System.out.println(atoi(strNum));
		
		String strNum2 = String.valueOf(num);
		String strNum3 = num+"";
		System.out.println(atoi(strNum2));
		System.out.println(atoi(strNum3));
		
	}
	 
	 static int atoi(String str) {
		 int N = str.length();
		 int num = 0;
		 
		 for(int i=0;i<N;i++) {
			 char c = str.charAt(i);
			 
			 if('0'<=c&&c<='9') {  // 48,57로 해도 됨
				 num = (num*10) + (c-'0');
			 }else {
				 return Integer.MIN_VALUE;
			 }
		 }
		 return num;
	 }
	 
	 static String itoa(int n) {
		 
		 
		 return null;
	 }
	 
	 
	 
}
