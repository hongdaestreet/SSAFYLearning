import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class tree_연습문제 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int V = Integer.parseInt(br.readLine());
		int[][] tree = new int[V+1][3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<V-1;i++) {
			int p = Integer.parseInt(st.nextToken());  // 부모
			int c = Integer.parseInt(st.nextToken());
			
			if (tree[p][0] == 0) {
				tree[p][0] = c;  // 왼쪽 자식 노드 저장
			}else {
				tree[p][1] = c;  /// 오른쪽 자식 저장
			}
			
			tree[c][2] = p;  // 부모 정보 저장
			
			
			
		}

		for (int i = 0; i<V+1;i++) {
			System.out.println(i+" : "+ Arrays.toString(tree[i]));
		}
		
		
	}
	static String input = "13\r\n"
			+ "1 2 1 3 2 4 3 5 3 6 4 7 5 8 5 9 6 10 6 11 7 12 11 13";
	
	
}
