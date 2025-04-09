import java.util.Arrays;

public class 퀵정렬_Lomuto {
	static int[] arr = { 7, 5, 6, 8, 1, 2, 3, 39 };
	static int N = arr.length;

	public static void main(String[] args) {
		System.out.println(Arrays.toString(arr));
		quickSort(0,N-1);
	}
	
	static void quickSort(int start, int end) {
		if (start < end) {
			int pivot = partition(start,end);
			quickSort(start, pivot-1);  // pivot 기준 앞쪽 정렬
			quickSort(pivot+1,end);  // pivot 기준 뒷쪽 정렬
		}
	}

	private static int partition(int start, int end) {
		int pivot = arr[end];  // 끝점을 pivot으로 함
		
		int i = start-1;  // 작은 값들의 경계

		for(int j=start;j<end;j++) {
			if (arr[j] <= pivot) {  // 현재 우너소가 pivot보다 작거나 같다면 i를 1증가시키고 i<->j 교환 -> pivot보다 작거나 같은 원소들이 pivot 앞쪽으로 몰리도록 함
				i++;
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				System.out.println(String.format("arr[%d]<>arr[%d] -> %s",i,j,Arrays.toString(arr)));
			}
		}
		
		int tmp = arr[i+1];
		arr[i+1] = arr[end];
		arr[end] = tmp;
		System.out.print(String.format("start : %d / pivot : %d / ",start,pivot));
		System.out.println(String.format("partition(%d,%d) -> %s",start,end,Arrays.toString(arr)));
		
		return i+1;
	}
}
