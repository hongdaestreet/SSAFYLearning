public class Stack04_함수호출 {
	
	public static void main(String[] args) {
 		System.out.println("메실");
 		int a =10;
 		func1();
 		System.out.println("메롱");
	}
	
	static void func1() {
		System.out.println("함1실");
		int a =20;
		func2(a);
		System.out.println("함1종");
	}
	
	static void func2(int a) {
		System.out.println("함2실");
		a=30;
		System.out.println("함2종");
	}
	
}
