import java.util.Arrays;

public class 퀵정렬_Hoare {
	static int[] arr = { 7, 5, 6, 8, 1, 2, 3, 39 };
	static int N = arr.length;

	public static void main(String[] args) {
		System.out.println(Arrays.toString(arr));
		quickSort(0,N-1);
	}
	
	static void quickSort(int start, int end) {
		if (start < end) {
			// partition 함수를 통해 피벗을 기준으로 배열을 두 부분으로 분할
			int pivot = partition(start,end);  // 기준점이 될 pivot 지정
			quickSort(start, pivot-1);  // 피벗보다 작은 부분(왼쪽 부분)을 재귀적으로 정렬
			quickSort(pivot+1,end);  // 피벗보다 큰 부분(오른쪽 부분)을 재귀적으로 정렬
		}
	}

	private static int partition(int start, int end) {
		int pivot = arr[start];
		
		int L = start+1; // 시작점
		int R = end;  // 끝점
		
		while(L<=R) {
			// L : pivot 보다 큰 값을 찾을때까지 이동
			while(L<=R && arr[L] <= pivot) L++;
			// R : pivot 이하 값을 찾을때까지 이동
			while (arr[R]>pivot)R--;
			// 조건에 부합하는 L,R찾으면 비교해서 앞쪽, 뒷쪽 순서 맞춰주기
			if(L<R) {
				int tmp = arr[L];
				arr[L] = arr[R];
				arr[R] = tmp;
			}
		}
		// while 문 종료 시, R 포인터는 피벗보다 작거나 같은 값 중 마지막 위치를 가리킴
		// pivot과 R끝점 swap
		int tmp = arr[start];
		arr[start] = arr[R];
		arr[R] = tmp;
		System.out.print(String.format("start : %d / pivot : %d / ",start,pivot));
		System.out.println(String.format("partition(%d,%d) -> %s",start,end,Arrays.toString(arr)));
		return R;
	}
}
