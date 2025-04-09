public class String04_패턴매칭 {
	 public static void main(String[] args) {
		String text = "tiss is a book";
		String p = "a b";
		System.out.println(matchingFor(text,p));
	}
	 
	 static int matchingFor(String t, String p) {
		 int N = t.length();
		 int M = p.length();
		 
		 for(int i=0;i<N-M+1;i++) {
			 boolean isOk = true;
			 for (int j=0;j<M;j++) {
				 if (t.charAt(i+j) != p.charAt(j)) {
					 isOk = false;
					 break;
				 }
			 }
			 if (isOk) return i;
		 }
		 return -1;
	 }	 
}
