
public class Tree01_순회 {
	
	public static char[] tree = new char[] {' ','A','B','C','D','E','F','G',' ',' ','H','I'};
	public static int N = tree.length;
	
	public static void main(String[] args) {
		System.out.println("전위 순회");
		preOrder(1);
	}
	
	// 전위 순회
	public static void preOrder(int v) { // 노드 번호 v
		
		if (v<N) {
			// 방문처리
			if (tree[v] != ' ') System.out.println(tree[v]);
			preOrder(v*2); // 왼쪽 자식 탐방
			preOrder(v*2+1); // 왼쪽 자식 탐방
			
			
		}
	}
	
	
}
