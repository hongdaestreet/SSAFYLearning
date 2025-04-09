import java.util.Arrays;

public class Heap01_Array구현 {
	static int[] heap;
	static int heapSize;
	
	public static void main(String[] args) {
		heap = new int[100];
		heapSize = 0;
		
		System.out.println(Arrays.toString(heap));
		heapPush(10);
		System.out.println(Arrays.toString(heap));
		heapPush(10);
		System.out.println(Arrays.toString(heap));
		heapPush(10);
		System.out.println(Arrays.toString(heap));
		heapPush(10);
		System.out.println(Arrays.toString(heap));
		heapPush(10);
		
		
		
	}
	
	public static int heapPop() {
		
	}
	
}
