import java.util.Arrays;

public class 병합정렬 {
	static int[] arr = { 7, 5, 6, 8, 1, 2, 3, 39 };
	static int N = arr.length;

	// 임시공간
	static int[] tmp = new int[N];

	public static void main(String[] args) {
		System.out.println(Arrays.toString(arr));  // 시작
		mergeSort(0, N - 1);
	}

	// 병합정렬
	// left~right-1 구간(index)을 정렬하는 함수
	static void mergeSort(int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2; // 분할
			mergeSort(start, mid); // 앞쪽 정렬 (정복)
			mergeSort(mid + 1, end); // 뒤쪽 정렬 (정복)
			merge(start, mid, end); // 병합
		}
	}
	
	// 각 부분집합은 정렬이 되어있는 상태에서 진행하는 거임
	static void merge(int start, int mid, int end) {
		int L = start;  // 처음
		int R = mid + 1;  // 중간 뒤(뒷쪽 배열 시작점)
		int idx = start; // 임시공간(tmp)의 인덱스

		// 분할 정렬된 list 합병
		while (L <= mid && R <= end) {  // 앞쪽이나 뒷쪽 배열 둘 중 하나가 다 찰 때까지ㄱㄱ
			if (arr[L] <= arr[R]) {  // 왼쪽 배열 요소가 더 작으면 왼쪽부터 넣기
				tmp[idx++] = arr[L++];  // 그리고 배열 이동
			} else {
				tmp[idx++] = arr[R++];
			}
		} // 한쪽구간은 전부 끝

		// 남아 있는 값들을 일괄 복사함
		if (L <= mid) {  // 앞쪽 배열이 남아있을 경우
			for (int i = L; i <= mid; i++) {
				tmp[idx++] = arr[i];
			}
		} else {  // 뒷쪽 배열이 남아있을 경우
			for (int i = R; i <= end; i++) {
				tmp[idx++] = arr[i];
			}
		}

		// 임시 배열 리스트를 원 배열 arr[]로 재복사
		for (int i = start; i <= end; i++) {
			arr[i] = tmp[i];
		}
		System.out.println(String.format("merge(%d,%d,%d) -> %s",start, mid, end, Arrays.toString(arr)));  // 디버깅
	}

}
