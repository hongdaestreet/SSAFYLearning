import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class String01_생성 {
	 public static void main(String[] args) {
		// 1. 리터럴 사용 -> String Pool
		 String str1 = "Hello";
		 String str2 = "Hello";
		 System.out.println(str1==str2);	// 같은 곳을 가리킴
		 
		 //2. 힙에 생성
		 String str3 = new String("Hello");
		 System.out.println(str1==str3);
		 System.out.println(str1.equals(str3));
		 
		 byte[] bytes = {65,66,67};
		 String str4 = new String(bytes, StandardCharsets.UTF_8);
		 System.out.println(str4);
		 
		 // 문자열은 불변성 가짐
		 // 문자를 하나씩 뽑아사 배열에 저장
		 char[] arr1 = new char[str1.length()];
		 for(int i=0;i<str1.length();i++) {
			 System.out.println(str1.charAt(i));
			 arr1[i] = str1.charAt(i);
		 }
		 System.out.println(Arrays.toString(arr1));
		
		 char[] arr2 = str1.toCharArray();
		 System.out.println(Arrays.toString(arr2));
		 
		 // Java에서 문자한개를 입력받는 방법 없음 -> charAt으로 하나하나씩 받아
		 // contains : 문자열 내 해당 인자 포함하는지 체크
		 String[] nums = "one two three".split(" ");
		 System.out.println(Arrays.toString(nums));
		 
		 
	}
}
