
public class Array03_2차원배열순회 {
	public static void main(String[] args) {
		int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		
		// 행 우선 순회 (순방향)
		System.out.println("행 우선 순회 (순방향)");
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {	// 헹 순회
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		// 행우선 순회 (역방향)
		System.out.println("\n행 우선 순회 (역방향)");
		for(int i=0;i<arr.length;i++) {
			for(int j=arr[i].length-1;j>=0;j--) {	// 헹 순회
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("\n열 우선 순회 (순방향)");
		for(int j=0;j<arr[0].length;j++) {
			for(int i=0;i<arr.length;i++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("\n열 우선 순회 (역방향)");
		for(int j=0;j<arr[0].length;j++) {
			for(int i=0;i<arr.length;i++) {
				System.out.print(arr[i][arr[i].length-1-j]+" ");
			}
			System.out.println();
		}
		

		System.out.println("\n지그재그 순회 (역방향)");
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
//				if (i%2==0){
//					System.out.print(arr[i][j]+" ");
//				}else {
//					System.out.print(arr[i][arr[i].length-1-j]+" ");
//				}
				// 위처럼 조건에 따라 하는 것이 아니라 한번에 작성할 수도 있음
				System.out.print(arr[i][j+(arr[i].length-1-2*j)*(i%2)]+" ");
			}
			System.out.println();
		}
		

		System.out.println("\n달팽이 순회");
        int N = 4;
        int[][] arrS = new int[N][N];  // 배열 선언
        
        int K = N;
        int dir = 1;
        int r = 0;
        int c = -1;
        int num = 1;
        
        while (true) {
            // 가로 방향 이동
            for (int i = 0; i < K; i++) {
                c += dir;
                arrS[r][c] = num++;
            }
            K--; // 변의 길이 감소
            
            // 종료 조건
            if (K == 0) break;
            
            // 세로 방향 이동
            for (int i = 0; i < K; i++) {
                r += dir;
                arrS[r][c] = num++;
            }
            dir = -dir; // 방향 전환
        }

        // 결과 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%2d ", arrS[i][j]);
            }
            System.out.println();
        }
	}
}
